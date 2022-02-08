package co.com.ecommercecarvajal.platform.modules.products.api;

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
import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.modules.products.usecase.ProcessProducts;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = ResponseConstant.PRODUCTS_URL, produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ProductsWebApi {


    @Autowired
    private ProcessProducts processProducts;

    @ApiOperation(
            value = ApiDocumentationConstant.POST_VALUE_PRODUCTS_WEB_API,
            notes = ApiDocumentationConstant.POST_NOTE_PRODUCTS_WEB_API,
            response = RequestDTO.class,
            responseContainer = ResponseConstant.SWAGGER_LIST)
    @PostMapping(ResponseConstant.PRODUCT_URL)
    public ResponseEntity<Object> customers(@RequestBody final List<ProductsDTO> listDTOs) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.STATUS, processProducts.saveProducts(listDTOs));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @ApiOperation(
            value = ApiDocumentationConstant.GET_VALUE_PRODUCT_WEB_API,
            notes = ApiDocumentationConstant.GET_NOTE_PRODUCT_WEB_API,
            response = RequestDTO.class)
    @GetMapping(ResponseConstant.PRODUCT_URL)
    public ResponseEntity<Object> getProduct(@RequestParam(name = "idProduct", required = true) Integer idProduct)
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.PRODUCT, processProducts.getProduct(idProduct));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }   
    
    @ApiOperation(
            value = ApiDocumentationConstant.GET_VALUE_PRODUCTS_WEB_API,
            notes = ApiDocumentationConstant.GET_NOTE_PRODUCTS_WEB_API,
            response = RequestDTO.class,
            responseContainer = ResponseConstant.SWAGGER_LIST)
    @GetMapping(ResponseConstant.PRODUCTS_URL)
    public ResponseEntity<Object> getProducts()
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.PRODUCT, processProducts.getProductAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 
    
    @ApiOperation(
            value = ApiDocumentationConstant.DEL_VALUE_PRODUCT_WEB_API,
            notes = ApiDocumentationConstant.DEL_NOTE_PRODUCT_WEB_API,
            response = RequestDTO.class)
    @DeleteMapping(ResponseConstant.PRODUCTS_URL)
    public ResponseEntity<Object> deleteProducts(
            @RequestParam(name = "idProduct", required = true) Integer idProduct)
            throws EBusinessApplicationException {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseConstant.STATUS, processProducts.deleteProduct(idProduct));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
