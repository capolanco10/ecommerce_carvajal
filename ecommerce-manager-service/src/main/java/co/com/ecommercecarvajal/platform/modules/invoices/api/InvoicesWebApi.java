package co.com.ecommercecarvajal.platform.modules.invoices.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ApiDocumentationConstant;
import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.InvoicesDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.modules.invoices.usecase.ProcessInvoices;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ResponseConstant.INVOICE_URL, produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class InvoicesWebApi {

	@Autowired
	private ProcessInvoices processInvoices;

	@ApiOperation(value = ApiDocumentationConstant.POST_VALUE_INVOICES_WEB_API, notes = ApiDocumentationConstant.POST_NOTE_INVOICES_WEB_API, response = RequestDTO.class)
	@PostMapping(ResponseConstant.INVOICE_URL)
	public ResponseEntity<Object> invoices(@RequestBody final InvoicesDTO invoicesDTO)
			throws EBusinessApplicationException {
		Map<String, Object> response = new HashMap<>();
		response.put(ResponseConstant.STATUS, processInvoices.saveInvoices(invoicesDTO));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
