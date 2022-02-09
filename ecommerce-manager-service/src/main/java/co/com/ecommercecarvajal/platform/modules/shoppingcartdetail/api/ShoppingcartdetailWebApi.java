package co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ApiDocumentationConstant;
import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.modules.shoppingcartdetail.usecase.ProcessShoppingcartdetail;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ResponseConstant.SHOPPINGCART_URL, produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class ShoppingcartdetailWebApi {

	@Autowired
	private ProcessShoppingcartdetail processShoppingcartdetail;

	@ApiOperation(value = ApiDocumentationConstant.GET_VALUE_SHOPPINGCARTDETAIL_WEB_API, notes = ApiDocumentationConstant.GET_NOTE_SHOPPINGCARTDETAI_WEB_API, response = RequestDTO.class)
	@GetMapping(ResponseConstant.SHOPPINGCARTDETAIL_URL)
	public ResponseEntity<Object> getShoppingcarts(@RequestParam final Integer idCustomer)
			throws EBusinessApplicationException {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseConstant.STATUS, processShoppingcartdetail.getShoppingcartsdetails(idCustomer));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
