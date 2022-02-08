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
public class ShoppingcartDetailDTO implements Serializable{

	private static final long serialVersionUID = 2662716598818992294L;
	
	private Integer id;
    private Integer idShoppingcart;
    private Integer idProduct;
    private Integer amount;
    private Double subtotal;
    private Double total;
}
