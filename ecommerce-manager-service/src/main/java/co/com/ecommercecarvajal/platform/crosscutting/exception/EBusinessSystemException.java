package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * Exception definition
 */

public class EBusinessSystemException extends EBusinessApplicationException {

    private static final long serialVersionUID = 1L;

    public EBusinessSystemException(final String message) {
        super(message);
    }

    public EBusinessSystemException(final String message,
            final Throwable cause) {
        super(message, cause);
    }

    public EBusinessSystemException(String message, Throwable cause,
            String code) {
        super(message, cause, code);
    }

}
