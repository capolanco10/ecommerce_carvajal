package co.com.ecommercecarvajal.platform.modules.customers.dataproviders;

import java.util.List;

import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;

public interface CustomersDataProvider {
	
	CustomersDTO saveCustomers(CustomersDTO customersDTO) throws EBusinessApplicationException;
	
	CustomersDTO getCustomer(Integer idCustomer) throws EBusinessApplicationException;
	
	List<CustomersDTO> getCustomerAll() throws EBusinessApplicationException;
	
	void deleteCustomer(Integer idCustomer) throws EBusinessApplicationException;

}
