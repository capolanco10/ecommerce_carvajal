package co.com.ecommercecarvajal.platform.crosscutting.exception;

/**
 * ConnectionDBException
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

public class ConnectionDBException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -1105797675448560320L;

    public ConnectionDBException(String detail) {
        super(detail);
    }

}
