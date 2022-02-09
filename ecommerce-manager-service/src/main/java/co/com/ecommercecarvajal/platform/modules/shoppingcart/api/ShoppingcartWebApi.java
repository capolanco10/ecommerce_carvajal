package co.com.ecommercecarvajal.platform.modules.shoppingcart.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ApiDocumentationConstant;
import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.modules.shoppingcart.usecase.ProcessShoppingcart;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ResponseConstant.SHOPPINGCART_URL, produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class ShoppingcartWebApi {

	@Autowired
	private ProcessShoppingcart processShoppingcart;

	@ApiOperation(value = ApiDocumentationConstant.POST_VALUE_SHOPPINGCART_WEB_API, notes = ApiDocumentationConstant.POST_NOTE_SHOPPINGCART_WEB_API, response = RequestDTO.class)
	@PostMapping(ResponseConstant.SHOPPINGCART_URL)
	public ResponseEntity<Object> saveShoppingcart(@RequestBody final ShoppingcartDTO shoppingcartDTO)
			throws EBusinessApplicationException {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseConstant.STATUS, processShoppingcart.saveShoppingcarts(shoppingcartDTO));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = ApiDocumentationConstant.DELETE_VALUE_SHOPPINGCART_WEB_API, notes = ApiDocumentationConstant.DELETE_NOTE_SHOPPINGCART_WEB_API, response = RequestDTO.class)
	@DeleteMapping(ResponseConstant.SHOPPINGCART_URL)
	public ResponseEntity<Object> deleteShoppingcart(@RequestBody final ShoppingcartDTO shoppingcartDTO)
			throws EBusinessApplicationException {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseConstant.STATUS, processShoppingcart.deleteShoppingcarts(shoppingcartDTO));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
}
