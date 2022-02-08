package co.com.ecommercecarvajal.platform.crosscutting.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class InvoicesExtDTO implements Serializable{

	private static final long serialVersionUID = -639757363292462343L;
	
	private Integer id;
	
    private Integer idCustomer;
    
    @JsonFormat(pattern = Constants.SIMPLE_DATE_TIME_FORMAT)
    private LocalDateTime invoiceDate;

    private Double totalInvoice;

    private Double totalIva;

}
