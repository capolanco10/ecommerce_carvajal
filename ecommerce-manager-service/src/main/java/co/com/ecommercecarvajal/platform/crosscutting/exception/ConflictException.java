package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * ConflictException
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

public class ConflictException extends RuntimeException {
    /**
    * 
    */
    private static final long serialVersionUID = -3276335489194114548L;

    public ConflictException(String detail) {
        super(detail);
    }

}
