package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Customers;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("customers")
public class CustomersTranslate implements Translator<CustomersDTO, Customers> {

    @Override
    public Customers translate(CustomersDTO customersDTO) {

        return Customers.builder()
        		.id(customersDTO.getId())
                .documentType(customersDTO.getDocumentType())
                .documentNumber(customersDTO.getDocumentNumber())
                .name(customersDTO.getName()).build();
    }

}
