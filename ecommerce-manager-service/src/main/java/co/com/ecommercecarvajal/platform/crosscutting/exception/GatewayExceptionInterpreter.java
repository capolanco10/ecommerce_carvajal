package co.com.ecommercecarvajal.platform.crosscutting.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.log4j.Log4j2;

/**
 * Exception builder artifact
 */

@Log4j2
public class GatewayExceptionInterpreter {

    public static EBusinessApplicationException interpret(
            final HttpStatusCodeException e) {

        log.warn("exception was thrown from downsstream service {} - {}",
                e.getRawStatusCode(), e.getResponseBodyAsString());
        String message = getDescription(e.getResponseBodyAsString());

        if (e.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            return ExceptionBuilder.builder().withMessage(message)
                    .buildBusinessException();
        }

        return ExceptionBuilder.builder().withMessage(message)
                .buildSystemException();
    }

    private static String getDescription(final String message) {
        try {
            DocumentContext dc = JsonPath.parse(message);
            return dc.read("$.description");
        } catch (Exception e) {
            return "no message was found in response";
        }
    }

}
