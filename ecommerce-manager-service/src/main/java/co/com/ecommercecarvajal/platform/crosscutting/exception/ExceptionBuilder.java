package co.com.ecommercecarvajal.platform.crosscutting.exception;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ExceptionType;

/**
 * Exception builder artifact
 */

public class ExceptionBuilder {

    private String code;
    private String message;
    private Throwable parentException;

    private ExceptionBuilder() {
    }

    public static ExceptionBuilder builder() {
        return new ExceptionBuilder();
    }

    public ExceptionBuilder withCode(final String code) {
        this.code = code;
        return this;
    }

    public ExceptionBuilder withMessage(final String message) {
        this.message = message;
        return this;
    }

    public ExceptionBuilder(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ExceptionBuilder withParentException(
            final Throwable parentException) {
        this.parentException = parentException;
        return this;
    }

    public EBusinessException buildBusinessException() {
        return this.code == null
                ? new EBusinessException(message, parentException)
                : new EBusinessException(message, parentException, code);
    }

    public EBusinessSystemException buildSystemException() {
        return this.code == null
                ? new EBusinessSystemException(message, parentException)
                : new EBusinessSystemException(message, parentException, code);
    }

    /**
     * This method allow you build an OSIIRuntimeApplicationException depending
     * on depending on the given type
     *
     * @param type OSIIRuntimeApplicationException type to throw
     * @return OSIIRuntimeApplicationException the parent wrapper
     */
    public EBusinessRuntimeApplicationException buildRuntimeException(
            final ExceptionType type) {

        switch (type) {
        case SYSTEN_RUNTIME_EXCEPTION:
            return this.code == null
                    ? new EBusinessRuntimeSystemException(message,
                            parentException)
                    : new EBusinessRuntimeSystemException(message,
                            parentException, code);

        case BUSINESS_RUNTIME_EXCEPTION:
            return this.code == null
                    ? new EBusinessRuntimeBusinessException(message,
                            parentException)
                    : new EBusinessRuntimeBusinessException(message,
                            parentException, code);

        default:
            return new EBusinessRuntimeSystemException(message,
                    parentException);
        }
    }

}
