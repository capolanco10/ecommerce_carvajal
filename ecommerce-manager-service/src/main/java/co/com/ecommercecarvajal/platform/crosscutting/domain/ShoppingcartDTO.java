/**
 * 
 */
package co.com.ecommercecarvajal.platform.crosscutting.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.ecommercecarvajal.platform.crosscutting.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingcartDTO implements Serializable{

	private static final long serialVersionUID = 4073757792639035116L;

	private Integer id;
	
	private Integer idCustomer;
    
   // @ApiModelProperty(value = "shoppingcartDate", name = "shoppingcartDate", example = ResponseConstant.DATE_TIME)
    @JsonFormat(pattern = Constants.SIMPLE_DATE_TIME_FORMAT)
    private LocalDateTime shoppingcartDate;
    
    private List<ShoppingcartDetailDTO> shoppingcartDetail;
}
