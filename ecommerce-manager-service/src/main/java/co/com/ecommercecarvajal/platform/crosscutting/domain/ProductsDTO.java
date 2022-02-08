/**
 * 
 */
package co.com.ecommercecarvajal.platform.crosscutting.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * @author carcorpo
 *
 */	
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsDTO implements Serializable{


	private static final long serialVersionUID = 7683006213772353819L;

	private Integer id;
    private String code;
    private Double unitPrice;
    private String description;
}
