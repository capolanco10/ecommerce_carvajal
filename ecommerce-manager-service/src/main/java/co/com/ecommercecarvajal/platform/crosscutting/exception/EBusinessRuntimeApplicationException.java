package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * EBusinessRuntimeApplicationException use to lambdas blocks or any other stage
 * where you need throw and exception
 */

public class EBusinessRuntimeApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    public EBusinessRuntimeApplicationException(final String message) {
        super(message);
    }

    public EBusinessRuntimeApplicationException(final String message,
            final Throwable cause) {
        super(message, cause);
    }

    public EBusinessRuntimeApplicationException(final String message,
            final Throwable cause, final String code) {
        super(message, cause);
        this.code = code;
    }

    public boolean isRuntimeBusinessException() {
        return this instanceof EBusinessRuntimeBusinessException;
    }

    public boolean isRuntimeSystemException() {
        return this instanceof EBusinessRuntimeSystemException;
    }

    public String getCode() {
        return this.code;
    }
}
