package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * Exception definition
 */

public class EBusinessApplicationException extends Exception {

    private static final long serialVersionUID = 1L;
    private String code;

    public EBusinessApplicationException(final String message) {
        super(message);
    }

    public EBusinessApplicationException(final String message,
            final Throwable cause) {
        super(message, cause);
    }

    public boolean isBusinessException() {
        return this instanceof EBusinessException;
    }

    public boolean isSystemException() {
        return this instanceof EBusinessSystemException;
    }

    public EBusinessApplicationException(final String message,
            final Throwable cause, final String code) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
