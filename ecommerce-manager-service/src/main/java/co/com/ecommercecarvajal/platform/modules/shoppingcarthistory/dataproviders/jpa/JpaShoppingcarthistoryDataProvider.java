package co.com.ecommercecarvajal.platform.modules.shoppingcarthistory.dataproviders.jpa;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Shoppingcarthistory;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.ShoppingcarthistoryRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.modules.shoppingcarthistory.dataproviders.ShoppingcarthistoryDataProvider;

@DataProvider
public class JpaShoppingcarthistoryDataProvider implements ShoppingcarthistoryDataProvider {

	@Autowired
	private ShoppingcarthistoryRepository shoppingcarthistoryRepository;

	@Override
	public void saveShoppingcarthistory(Shoppingcarthistory entity) throws EBusinessApplicationException {
		shoppingcarthistoryRepository.save(entity);
	}
}
