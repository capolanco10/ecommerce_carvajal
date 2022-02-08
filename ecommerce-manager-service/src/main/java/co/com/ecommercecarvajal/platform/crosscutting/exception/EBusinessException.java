package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * Exception definition
 */

public class EBusinessException extends EBusinessApplicationException {

    private static final long serialVersionUID = 1L;

    public EBusinessException(final String message) {
        super(message);
    }

    public EBusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EBusinessException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }

}
