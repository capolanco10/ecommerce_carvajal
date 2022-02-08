package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.CustomersDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Customers;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("customersDTO")
public class CustomersDTOTranslate implements Translator<Customers, CustomersDTO> {

    @Override
    public CustomersDTO translate(Customers entity) {

        return CustomersDTO.builder()
        		.id(entity.getId())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .name(entity.getName()).build();
    }

}
