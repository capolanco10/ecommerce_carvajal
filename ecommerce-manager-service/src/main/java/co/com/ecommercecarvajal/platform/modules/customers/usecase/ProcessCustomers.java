package co.com.ecommercecarvajal.platform.modules.customers.usecase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ecommercecarvajal.platform.crosscutting.constants.ResponseConstant;
import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.RequestDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessRuntimeBusinessException;
import co.com.ecommercecarvajal.platform.crosscutting.messages.CustomersMessages;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.UseCase;
import co.com.ecommercecarvajal.platform.modules.customers.dataproviders.CustomersDataProvider;

/**
 * Process Shift use case.
 */

//@Log4j2
@UseCase
public class ProcessCustomers {

    @Autowired
    private CustomersDataProvider customersDataProvider;

    public List<RequestDTO> saveCustomers(List<CustomersDTO> listDTOs) {
    	
    	return listDTOs.stream()
    					.map(customers ->{
    						try {
    							return new RequestDTO(ResponseConstant.SUCCESSFUL, customersDataProvider.saveCustomers(customers));
    						} catch (EBusinessApplicationException e) {
    			                throw new EBusinessRuntimeBusinessException(CustomersMessages.CUSTOMERS_ERROR_SAVE);
    			            }
    					})
    					.collect(Collectors.toCollection(ArrayList::new));
    }
    
    public RequestDTO getCustomer(Integer idCustomer) throws EBusinessApplicationException {
    	
    	return new RequestDTO(ResponseConstant.SUCCESSFUL, customersDataProvider.getCustomer(idCustomer));
    }    
    
    public List<RequestDTO> getCustomerAll() throws EBusinessApplicationException {
    	
        return Arrays.asList(new RequestDTO(ResponseConstant.SUCCESSFUL, customersDataProvider.getCustomerAll()));
    } 
    
    public RequestDTO deleteCustomer(Integer idCustomer) throws EBusinessApplicationException {
    	customersDataProvider.deleteCustomer(idCustomer);
    	return new RequestDTO(ResponseConstant.SUCCESSFUL, CustomersMessages.DELETE_CUSTOMER);
    }
}
