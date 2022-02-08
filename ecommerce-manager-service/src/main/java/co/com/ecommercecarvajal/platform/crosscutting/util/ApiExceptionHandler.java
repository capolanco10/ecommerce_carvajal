package co.com.ecommercecarvajal.platform.crosscutting.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.com.ecommercecarvajal.platform.crosscutting.exception.BadGatewayException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.BadRequestException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.ConflictException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.ConnectionDBException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.ForbiddenException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.NotFoundException;
import lombok.extern.log4j.Log4j2;

/**
 * ApiExceptionHandler
 */

@Log4j2
@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class })
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ BadRequestException.class, org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.web.server.ServerWebInputException.class })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ ConflictException.class })
    @ResponseBody
    public ErrorMessage conflict(Exception exception) {
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({ ForbiddenException.class })
    @ResponseBody
    public ErrorMessage forbidden(Exception exception) {
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.FORBIDDEN.value());
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler({ BadGatewayException.class })
    @ResponseBody
    public ErrorMessage badGateway(Exception exception) {
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.BAD_GATEWAY.value());
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({ ConnectionDBException.class, org.hibernate.exception.JDBCConnectionException.class,
            org.springframework.dao.DataAccessResourceFailureException.class })
    @ResponseBody
    public ErrorMessage exceptionDBConnection(Exception exception) { // The error must be corrected
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.SERVICE_UNAVAILABLE.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ErrorMessage exception(Exception exception) { // The error must be corrected
        log.error(exception);
        return new ErrorMessage(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
