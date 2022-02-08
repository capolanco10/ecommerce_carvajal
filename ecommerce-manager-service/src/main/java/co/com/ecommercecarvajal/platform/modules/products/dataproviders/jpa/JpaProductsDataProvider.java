package co.com.ecommercecarvajal.platform.modules.products.dataproviders.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.ExceptionBuilder;
import co.com.ecommercecarvajal.platform.crosscutting.messages.ProductsMessages;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Products;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.ProductsRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ProductsDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ProductsTranslate;
import co.com.ecommercecarvajal.platform.modules.products.dataproviders.ProductsDataProvider;

@DataProvider
public class JpaProductsDataProvider implements ProductsDataProvider {

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	@Qualifier("products")
	private ProductsTranslate productsTranslate;

	@Autowired
	@Qualifier("productsDTO")
	private ProductsDTOTranslate productsDTOTranslate;

	@Override
	public ProductsDTO saveProducts(ProductsDTO productsDTO) throws EBusinessApplicationException {
		Products entityTemp = productsTranslate.translate(productsDTO);
		return productsDTOTranslate.translate(productsRepository.save(entityTemp));
	}

	@Override
	public ProductsDTO getProduct(Integer idProduct) throws EBusinessApplicationException {
		Optional<Products> products = productsRepository.findById(idProduct);
		if (products.isEmpty()) {
			//printErrorLog.printLog(SpecificShiftDeliveryCenterConstants.SPECIFIC_SHIFT_FIND,
			//		SpecificShiftDeliveryCenterMessages.SPECIFIC_SHIFT_DELIVER_CENTER_ERROR);
			throw ExceptionBuilder.builder()
					.withCode(ProductsMessages.COD_PRODUCT_ERROR)
					.withMessage(ProductsMessages.GET_PRODUCT_ERROR)
					.buildBusinessException();
		}
		return productsDTOTranslate.translate(products.get());
	}

	@Override
	public List<ProductsDTO> getProductAll() throws EBusinessApplicationException {
        List<Products> products = productsRepository.findAll();
        List<ProductsDTO> listProductsDto = new ArrayList<>();
        products.forEach(customer -> listProductsDto.add(productsDTOTranslate.translate(customer)));
        return listProductsDto;
	}

	@Override
	public void deleteProduct(Integer idProduct) throws EBusinessApplicationException {
		productsRepository.deleteById(idProduct);
	}

}
