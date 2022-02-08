package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * Exception definition
 */

public class EBusinessRuntimeSystemException
        extends EBusinessRuntimeApplicationException {

    private static final long serialVersionUID = 1L;

    public EBusinessRuntimeSystemException(String message, Throwable cause,
            String code) {
        super(message, cause, code);
    }

    public EBusinessRuntimeSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public EBusinessRuntimeSystemException(String message) {
        super(message);
    }

}
