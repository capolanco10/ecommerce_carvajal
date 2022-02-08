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
public class ShoppingcartDetailResponseDTO implements Serializable{

	private static final long serialVersionUID = -1027442754374155272L;

	private Integer id;
	
    private Integer idCustomer;
    
    @JsonFormat(pattern = Constants.SIMPLE_DATE_TIME_FORMAT)
    private LocalDateTime shoppingcartDate;

    private Double totalInvoice;

    private Double totalIva;
    
    private List<ShoppingcartDetailDTO> shoppingcartDetail;

}
