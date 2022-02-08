package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * EBusinessRuntimeBusinessException use to lambdas blocks or any other stage
 * where you need throw and exception
 */

public class EBusinessRuntimeBusinessException
        extends EBusinessRuntimeApplicationException {

    private static final long serialVersionUID = 1L;

    public EBusinessRuntimeBusinessException(String message) {
        super(message);
    }

    public EBusinessRuntimeBusinessException(String message, Throwable cause,
            String code) {
        super(message, cause, code);
    }

    public EBusinessRuntimeBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
