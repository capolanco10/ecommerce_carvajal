package co.com.ecommercecarvajal.platform.modules.products.usecase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessRuntimeBusinessException;
import co.com.ecommercecarvajal.platform.crosscutting.messages.ProductsMessages;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.UseCase;
import co.com.ecommercecarvajal.platform.modules.products.dataproviders.ProductsDataProvider;
import lombok.extern.log4j.Log4j2;

/**
 * Process Shift use case.
 */

@Log4j2
@UseCase
public class ProcessProducts {

    @Autowired
    private ProductsDataProvider productsDataProvider;

    public List<RequestDTO> saveProducts(List<ProductsDTO> listDTOs) {
    	
    	return listDTOs.stream()
    					.map(products ->{
    						try {
    							return new RequestDTO(ResponseConstant.SUCCESSFUL, productsDataProvider.saveProducts(products));
    						} catch (EBusinessApplicationException e) {
    			                throw new EBusinessRuntimeBusinessException(ProductsMessages.PRODUCTS_ERROR_SAVE);
    			            }
    					})
    					.collect(Collectors.toCollection(ArrayList::new));
    }
    
    public RequestDTO getProduct(Integer idProduct) throws EBusinessApplicationException {
    	
    	return new RequestDTO(ResponseConstant.SUCCESSFUL, productsDataProvider.getProduct(idProduct));
    }    
    
    public List<RequestDTO> getProductAll() throws EBusinessApplicationException {
    	
        return Arrays.asList(new RequestDTO(ResponseConstant.SUCCESSFUL, productsDataProvider.getProductAll()));
    } 
    
    public RequestDTO deleteProduct(Integer idProduct) throws EBusinessApplicationException {
    	productsDataProvider.deleteProduct(idProduct);
    	return new RequestDTO(ResponseConstant.SUCCESSFUL, ProductsMessages.DELETE_PRODUCT);
    }
}
