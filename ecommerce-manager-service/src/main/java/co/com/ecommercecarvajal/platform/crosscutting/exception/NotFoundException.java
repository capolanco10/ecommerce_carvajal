package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * NotFoundException
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

public class NotFoundException extends RuntimeException {
    /**
    * 
    */
    private static final long serialVersionUID = 5538185387829847034L;

    public NotFoundException(String detail) {
        super(detail);
    }

}
