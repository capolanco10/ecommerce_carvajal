package co.com.ecommercecarvajal.platform.modules.products.dataproviders;

import java.util.List;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface ProductsDataProvider {
	
	ProductsDTO saveProducts(ProductsDTO productsDTO) throws EBusinessApplicationException;
	
	ProductsDTO getProduct(Integer idProduct) throws EBusinessApplicationException;
	
	List<ProductsDTO> getProductAll() throws EBusinessApplicationException;
	
	void deleteProduct(Integer idProduct) throws EBusinessApplicationException;

}
