package co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.dataproviders;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface ShoppingcartDetailDataProvider {
	
	ShoppingcartDetailDTO saveShoppingcartDetail(ShoppingcartDetailDTO shoppingcarts) throws EBusinessApplicationException;

}
