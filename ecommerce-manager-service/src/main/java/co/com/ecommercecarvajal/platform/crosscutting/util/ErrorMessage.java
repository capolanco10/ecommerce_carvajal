package co.com.ecommercecarvajal.platform.crosscutting.util;

/**
 * ErrorMessage
 *
 * @author Alvaro Javier Rozo
 * @version 1.0
 * @since 2021-09-23
 *
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
class ErrorMessage {

    private final String id;
    private final Integer status;
    private final String code;
    private final String title;
    private final String datail;

    ErrorMessage(Exception exception, Integer code) {
        this.id = java.util.UUID.randomUUID().toString().replace("-", "");
        this.status = code;
        this.code = "" + exception.hashCode();
        this.title = exception.getClass().getSimpleName();
        this.datail = exception.getMessage();
    }
}
