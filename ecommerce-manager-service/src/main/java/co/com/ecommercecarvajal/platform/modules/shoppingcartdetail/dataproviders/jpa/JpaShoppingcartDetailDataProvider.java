package co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.dataproviders.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.ShoppingcartDetailRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ShoppingcartDetailDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ShoppingcartDetailTranslate;
import co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.dataproviders.ShoppingcartDetailDataProvider;

@DataProvider
public class JpaShoppingcartDetailDataProvider implements ShoppingcartDetailDataProvider {

	@Autowired
	private ShoppingcartDetailRepository shoppingcartDetailRepository;

	@Autowired
	@Qualifier("shoppingcartDetail")
	private ShoppingcartDetailTranslate shoppingcartDetailTranslate;

	@Autowired
	@Qualifier("shoppingcartDetailDTO")
	private ShoppingcartDetailDTOTranslate shoppingcartDetailDTOTranslate;

	@Override
	public ShoppingcartDetailDTO saveShoppingcartDetail(ShoppingcartDetailDTO entity) throws EBusinessApplicationException {
		return shoppingcartDetailDTOTranslate.translate(shoppingcartDetailRepository.save(shoppingcartDetailTranslate.translate(entity)));
	}
	
	@Override
	public void deleteShoppingcartDetail(ShoppingcartDetailDTO entity) throws EBusinessApplicationException {
		shoppingcartDetailRepository.delete(shoppingcartDetailTranslate.translate(entity));
	}
}
