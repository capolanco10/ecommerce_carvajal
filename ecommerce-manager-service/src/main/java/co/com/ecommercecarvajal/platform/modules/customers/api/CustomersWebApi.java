package co.com.ecommercecarvajal.platform.modules.customers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ApiDocumentationConstant;
import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.modules.customers.usecase.ProcessCustomers;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ResponseConstant.CUSTOMERS_URL, produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class CustomersWebApi {


    @Autowired
    private ProcessCustomers processCustomers;

    @ApiOperation(
            value = ApiDocumentationConstant.POST_VALUE_CUSTOMERS_WEB_API,
            notes = ApiDocumentationConstant.POST_NOTE_CUSTOMERS_WEB_API,
            response = RequestDTO.class,
            responseContainer = ResponseConstant.SWAGGER_LIST)
    @PostMapping(ResponseConstant.CUSTOMER_URL)
    public ResponseEntity<Object> customers(@RequestBody final List<CustomersDTO> listDTOs) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.STATUS, processCustomers.saveCustomers(listDTOs));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @ApiOperation(
            value = ApiDocumentationConstant.GET_VALUE_CUSTOMER_WEB_API,
            notes = ApiDocumentationConstant.GET_NOTE_CUSTOMER_WEB_API,
            response = RequestDTO.class)
    @GetMapping(ResponseConstant.CUSTOMER_URL)
    public ResponseEntity<Object> getCustomer(@RequestParam(name = "idCustomer", required = true) Integer idCustomer)
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.CUSTOMER, processCustomers.getCustomer(idCustomer));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }   
    
    @ApiOperation(
            value = ApiDocumentationConstant.GET_VALUE_CUSTOMERS_WEB_API,
            notes = ApiDocumentationConstant.GET_NOTE_CUSTOMERS_WEB_API,
            response = RequestDTO.class,
            responseContainer = ResponseConstant.SWAGGER_LIST)
    @GetMapping(ResponseConstant.CUSTOMERS_URL)
    public ResponseEntity<Object> getCustomers()
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.CUSTOMER, processCustomers.getCustomerAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 
    
    @ApiOperation(
            value = ApiDocumentationConstant.DEL_VALUE_CUSTOMER_WEB_API,
            notes = ApiDocumentationConstant.DEL_NOTE_CUSTOMER_WEB_API,
            response = RequestDTO.class)
    @DeleteMapping(ResponseConstant.CUSTOMERS_URL)
    public ResponseEntity<Object> deleteCustomers(
            @RequestParam(name = "idCustomer", required = true) Integer idCustomer)
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.STATUS, processCustomers.deleteCustomer(idCustomer));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
