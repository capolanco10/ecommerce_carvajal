package co.com.ecommercecarvajal.platform.modules.shoppingcarthistory.dataproviders;

import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Shoppingcarthistory;

public interface ShoppingcarthistoryDataProvider {
	
	void saveShoppingcarthistory(Shoppingcarthistory shoppingcarts) throws EBusinessApplicationException;
}
