package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * BadRequestException
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

public class BadRequestException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -3835304752099910687L;

    public BadRequestException(String detail) {
        super(detail);
    }

}
