package co.com.ecommercecarvajal.platform.crosscutting.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CustomersDTO implements Serializable{

	private static final long serialVersionUID = 6971073886784547927L;
	
	private Integer id;
	private Integer documentType;
	private String documentNumber;
	private String name;

}
