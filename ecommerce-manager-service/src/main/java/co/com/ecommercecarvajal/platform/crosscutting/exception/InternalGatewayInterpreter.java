package co.com.ecommercecarvajal.platform.crosscutting.exception;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import co.com.ecommercecarvajal.platform.crosscutting.util.CheckUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Exception builder artifact
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InternalGatewayInterpreter {

    private static final String XML_PREFIX = "tns:";
    private static final String DESCRIPTION = "description";
    private static final String CODE = "code";
    private static final String STATUS = "status";

    public static EBusinessApplicationException interpret(
            final HttpStatusCodeException e) {

        log.warn("exception was thrown from downstream service {} - {}",
                e.getRawStatusCode(), e.getResponseBodyAsString());

        String exceptionMessage = getParamFromJson(e.getResponseBodyAsString(),
                DESCRIPTION);
        String exceptionCode = getParamFromJson(e.getResponseBodyAsString(),
                CODE);

        ExceptionBuilder exceptionBuilder = ExceptionBuilder.builder();

        if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            return exceptionBuilder
                    .withMessage(isNotEmpty(exceptionMessage) ? exceptionMessage
                            : e.getResponseBodyAsString())
                    .withCode(isNotEmpty(exceptionCode) ? exceptionCode
                            : HttpStatus.BAD_REQUEST.toString())
                    .buildBusinessException();
        }

        return exceptionBuilder.buildSystemException();
    }

    /**
     * This method allow you interpret exceptions when its body is a xml and
     * build an OSIIApplicationException exception type. The follow parameters
     * are expected on exception's body: tns:description, tns:code, tns:status.
     * If they aren't present you will have wrong results Be aware about
     * OSIApplicationException's message that will be return cause this contains
     * both, exception message an status separated by a "-" character
     * 
     * @param e wrapper where the exception resides
     * @return {@link EBusinessApplicationException}
     */
    public static EBusinessApplicationException interpretXml(
            final HttpStatusCodeException e) {

        log.warn("exception was thrown from downstream service {} - {}",
                e.getRawStatusCode(), e.getResponseBodyAsString());

        String exceptionCode = getParamFromXml(e.getResponseBodyAsString(),
                XML_PREFIX.concat(CODE));
        String exceptionStatus = getParamFromXml(e.getResponseBodyAsString(),
                XML_PREFIX.concat(STATUS));
        String exceptionMessage = getParamFromXml(e.getResponseBodyAsString(),
                XML_PREFIX.concat(DESCRIPTION));

        return e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)
                ? ExceptionBuilder.builder()
                        .withMessage(exceptionMessage.concat("-")
                                .concat(exceptionStatus))
                        .withCode(exceptionCode).buildBusinessException()
                : ExceptionBuilder.builder()
                        .withMessage(exceptionMessage.concat("-")
                                .concat(exceptionStatus))
                        .withCode(exceptionCode).buildSystemException();
    }

    private static String getParamFromJson(final String message,
            final String param) {
        try {

            log.info("getting param: {} from json", param);

            DocumentContext dc = JsonPath.parse(message);

            if (StringUtils.isBlank(param)) {
                log.info("param is empty");
                return CheckUtil.checkNullString(param);
            }

            if (message.contains(param)) {
                return dc.read("$.".concat(param));
            }

            return "";
        } catch (Exception e) {
            return "error translating message";
        }
    }

    /**
     * This method allow you read an xml message and get some node's value by
     * it's name
     * 
     * @param message the xml message where node resides
     * @param node    the node to search within the xml message
     * @return {@link String} node's value
     */
    private static String getParamFromXml(final String message,
            final String node) {

        try {

            log.info("getting node: {} from xml", node);
            InputSource source = new InputSource(new StringReader(message));

            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(source);
            document.getDocumentElement().normalize();

            return document.getElementsByTagName(node).item(0).getTextContent();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error("problems while looking fot node: {}", node);
            return "error looking for node inside the message";
        }

    }

}
