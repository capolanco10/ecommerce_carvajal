package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Shoppingcart;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("shoppingcart")
public class ShoppingcartTranslate implements Translator<ShoppingcartExtDTO, Shoppingcart> {

    @Override
    public Shoppingcart translate(ShoppingcartExtDTO invoicesExtDTO) {

        return Shoppingcart.builder()
        		.id(invoicesExtDTO.getId())
                .idCustomer(invoicesExtDTO.getIdCustomer())
                .shoppingcartDate(invoicesExtDTO.getShoppingcartDate())
                .totalInvoice(invoicesExtDTO.getTotalInvoice())
                .totalIva(invoicesExtDTO.getTotalIva()).build();
    }

}
