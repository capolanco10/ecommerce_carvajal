package co.com.ecommercecarvajal.platform.modules.shoppingcart.dataproviders.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.ShoppingcartRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ShoppingcartExtTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ShoppingcartTranslate;
import co.com.ecommercecarvajal.platform.modules.shoppingcart.dataproviders.ShoppingcartDataProvider;

@DataProvider
public class JpaShoppingcartDataProvider implements ShoppingcartDataProvider {

	@Autowired
	private ShoppingcartRepository shoppingcartRepository;

	@Autowired
	@Qualifier("shoppingcart")
	private ShoppingcartTranslate shoppingcartTranslate;

	@Autowired
	@Qualifier("shoppingcartExt")
	private ShoppingcartExtTranslate shoppingcartExtTranslate;

	@Override
	public ShoppingcartExtDTO saveShoppingcart(ShoppingcartExtDTO entity) throws EBusinessApplicationException {
		return shoppingcartExtTranslate.translate(shoppingcartRepository.save(shoppingcartTranslate.translate(entity)));
	}

}
