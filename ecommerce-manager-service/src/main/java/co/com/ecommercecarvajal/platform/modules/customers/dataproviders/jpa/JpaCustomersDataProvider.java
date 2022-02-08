package co.com.ecommercecarvajal.platform.modules.customers.dataproviders.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.exception.EBusinessApplicationException;
import co.com.ecommercecarvajal.platform.crosscutting.exception.ExceptionBuilder;
import co.com.ecommercecarvajal.platform.crosscutting.messages.CustomersMessages;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Customers;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.repository.CustomersRepository;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DataProvider;
import co.com.ecommercecarvajal.platform.crosscutting.translator.CustomersDTOTranslate;
import co.com.ecommercecarvajal.platform.crosscutting.translator.CustomersTranslate;
import co.com.ecommercecarvajal.platform.modules.customers.dataproviders.CustomersDataProvider;

@DataProvider
public class JpaCustomersDataProvider implements CustomersDataProvider {

	@Autowired
	private CustomersRepository customersRepository;

	@Autowired
	@Qualifier("customers")
	private CustomersTranslate customersTranslate;

	@Autowired
	@Qualifier("customersDTO")
	private CustomersDTOTranslate customersDTOTranslate;

	@Override
	public CustomersDTO saveCustomers(CustomersDTO customersDTO) throws EBusinessApplicationException {
		Customers entityTemp = customersTranslate.translate(customersDTO);
		return customersDTOTranslate.translate(customersRepository.save(entityTemp));
	}

	@Override
	public CustomersDTO getCustomer(Integer idCustomer) throws EBusinessApplicationException {
		Optional<Customers> customers = customersRepository.findById(idCustomer);
		if (customers.isEmpty()) {
			//printErrorLog.printLog(SpecificShiftDeliveryCenterConstants.SPECIFIC_SHIFT_FIND,
			//		SpecificShiftDeliveryCenterMessages.SPECIFIC_SHIFT_DELIVER_CENTER_ERROR);
			throw ExceptionBuilder.builder()
					.withCode(CustomersMessages.COD_CUSTOMER_ERROR)
					.withMessage(CustomersMessages.GET_CUSTOMER_ERROR)
					.buildBusinessException();
		}
		return customersDTOTranslate.translate(customers.get());
	}

	@Override
	public List<CustomersDTO> getCustomerAll() throws EBusinessApplicationException {
        List<Customers> customers = customersRepository.findAll();
        List<CustomersDTO> listCustomersDto = new ArrayList<>();
        customers.forEach(customer -> listCustomersDto.add(customersDTOTranslate.translate(customer)));
        return listCustomersDto;
	}

	@Override
	public void deleteCustomer(Integer idCustomer) throws EBusinessApplicationException {
		customersRepository.deleteById(idCustomer);
	}

}
