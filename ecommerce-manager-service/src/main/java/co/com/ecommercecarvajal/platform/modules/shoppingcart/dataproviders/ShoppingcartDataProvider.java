package co.com.ecommercecarvajal.platform.modules.shoppingcart.dataproviders;

import java.util.List;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface ShoppingcartDataProvider {
	
	ShoppingcartExtDTO saveShoppingcart(ShoppingcartExtDTO shoppingcart) throws EBusinessApplicationException;
	
	List<ShoppingcartExtDTO> getShoppingcarts(Integer idCustomer);

}
