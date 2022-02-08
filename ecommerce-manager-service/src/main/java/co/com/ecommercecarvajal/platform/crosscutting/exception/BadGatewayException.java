package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * BadGatewayException
 *
 */

public class BadGatewayException extends RuntimeException {
    /**
    * 
    */
    private static final long serialVersionUID = 1901240503857976826L;

    public BadGatewayException(String detail) {
        super(detail);
    }

}
