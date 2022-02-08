package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * ForbiddenException
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

public class ForbiddenException extends RuntimeException {
    /**
    * 
    */
    private static final long serialVersionUID = 3892838358268046699L;

    public ForbiddenException(String detail) {
        super(detail);
    }

}
