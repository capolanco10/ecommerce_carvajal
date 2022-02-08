package co.com.ecommercecarvajal.platform.crosscutting.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ShiftDTO
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO implements Serializable {

    private static final long serialVersionUID = 2439511167906990236L;

    private String status;
    private Object data;
}
