package co.com.ecommercecarvajal.platform.modules.shoppingcart.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailResponseDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.BadRequestException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessRuntimeBusinessException;
import co.com.ecommercecarvajal.platform.crosscutting.messages.CustomersMessages;
import co.com.ecommercecarvajal.platform.crosscutting.messages.ProductsMessages;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.UseCase;
import co.com.ecommercecarvajal.platform.crosscutting.translator.ShoppingcartDetailResponseDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.util.ConfigurationParameterGeneral;
import co.com.ecommercecarvajal.platform.modules.shoppingcart.dataproviders.ShoppingcartDataProvider;
import co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.dataproviders.ShoppingcartDetailDataProvider;

/**
 * Process Shift use case.
 */

//@Log4j2
@UseCase
public class ProcessShoppingcart {

	@Autowired
	private ShoppingcartDataProvider shoppingcartDataProvider;
	
	@Autowired
	private ShoppingcartDetailDataProvider shoppingcartDetailDataProvider;
	
	@Autowired
	private ConfigurationParameterGeneral configurationParameterGeneral;
	
	@Autowired
	private ShoppingcartDetailResponseDTOTranslate shoppingcartDetailResponseDTOTranslate;

	public RequestDTO saveShoppingcarts(ShoppingcartDTO shoppingcartDTO) throws EBusinessApplicationException {

		List<ShoppingcartDetailDTO> invoideDetailList = validateDetail(shoppingcartDTO.getShoppingcartDetail());
		
		if(shoppingcartDTO.getIdCustomer() == null) {
			throw new BadRequestException(CustomersMessages.CUSTOMER_NOTNULL);
		}
		
		ShoppingcartDetailResponseDTO shoppingcartDetailResponseDTO = new ShoppingcartDetailResponseDTO();
		
		if(invoideDetailList != null) {
			
			Double total = invoideDetailList.stream()
					.map(ShoppingcartDetailDTO::getTotal)
					.collect(Collectors.summingDouble(Double::doubleValue));
			
			//save shoppingcart
			ShoppingcartExtDTO shoppingcartExtDTO = shoppingcartDataProvider.saveShoppingcart(new ShoppingcartExtDTO
					(null, shoppingcartDTO.getIdCustomer(), shoppingcartDTO.getShoppingcartDate(), total, calculateIVA(total)));
			
			//save detail invoce
			List<ShoppingcartDetailDTO> invoideDetailDTOList = invoideDetailList.stream()
				.map(shoppingcartDetail ->{
					shoppingcartDetail.setIdShoppingcart(shoppingcartExtDTO.getId());
					try {
						return shoppingcartDetailDataProvider.saveShoppingcartDetail(shoppingcartDetail);
					} catch (EBusinessApplicationException e) {
						throw new EBusinessRuntimeBusinessException(ProductsMessages.PRODUCTS_ERROR_SAVE);
					}
				})
				.collect(Collectors.toCollection(ArrayList::new));
			
			shoppingcartDetailResponseDTO = shoppingcartDetailResponseDTOTranslate.translate(shoppingcartExtDTO);
			shoppingcartDetailResponseDTO.setShoppingcartDetail(invoideDetailDTOList);
		}
		
		return new RequestDTO(ResponseConstant.SUCCESSFUL, shoppingcartDetailResponseDTO);
	}

	/**
	 * metodo que valida todos los detalles de la factura
	 * 
	 * @param shoppingcartDetailDTOs
	 * @return
	 */
	private List<ShoppingcartDetailDTO> validateDetail(List<ShoppingcartDetailDTO> shoppingcartDetailDTOs) {
		
		shoppingcartDetailDTOs.stream()
		.forEach(product -> {
			if (product.getIdProduct() == null) {
				throw new BadRequestException(ProductsMessages.PRODUCT_NOTNULL);
			}
		});

		return shoppingcartDetailDTOs.stream()
			.map(products -> {
				return new ShoppingcartDetailDTO(null, null, products.getIdProduct(), products.getAmount(), products.getSubtotal(), Double.valueOf(products.getAmount() * products.getSubtotal()));
			})
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	private Double calculateIVA(Double total) {
		
		Integer iva = configurationParameterGeneral.getIva();
		Double ivaTotal = 0.0;
		
		if(iva != null && iva > 0) {
			ivaTotal = ((total * iva) /100);
		}
		
		return ivaTotal;
	}
}

