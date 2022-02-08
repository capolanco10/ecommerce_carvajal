package co.com.ecommercecarvajal.platform.modules.shoppingcart.dataproviders;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface ShoppingcartDataProvider {
	
	ShoppingcartExtDTO saveShoppingcart(ShoppingcartExtDTO shoppingcart) throws EBusinessApplicationException;

}
