package co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailResponseDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.BadRequestException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.messages.CustomersMessages;
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
public class ProcessShoppingcartdetail {

	@Autowired
	private ShoppingcartDataProvider shoppingcartDataProvider;
	
	@Autowired
	private ShoppingcartDetailDataProvider shoppingcartDetailDataProvider;
	
	@Autowired
	private ConfigurationParameterGeneral configurationParameterGeneral;
	
	@Autowired
	private ShoppingcartDetailResponseDTOTranslate shoppingcartDetailResponseDTOTranslate;

	public RequestDTO getShoppingcartsdetails(Integer idCustomer) throws EBusinessApplicationException {

		if(idCustomer == null) {
			throw new BadRequestException(CustomersMessages.CUSTOMER_NOTNULL);
		}
			
		List<ShoppingcartExtDTO> shoppingcartExtDTOs = shoppingcartDataProvider.getShoppingcarts(idCustomer);
		
		ShoppingcartDetailResponseDTO shoppingcartDetailResponseDTO = new ShoppingcartDetailResponseDTO();
		
		shoppingcartDetailResponseDTO = shoppingcartDetailResponseDTOTranslate.translate(shoppingcartExtDTOs.get(0));
		shoppingcartDetailResponseDTO.setShoppingcartDetail(null);
		
		return new RequestDTO(ResponseConstant.SUCCESSFUL, shoppingcartDetailResponseDTO);
	}
}

