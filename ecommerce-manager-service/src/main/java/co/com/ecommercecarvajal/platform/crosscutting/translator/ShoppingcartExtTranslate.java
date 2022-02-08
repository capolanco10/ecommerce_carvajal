package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Shoppingcart;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("shoppingcartExt")
public class ShoppingcartExtTranslate implements Translator<Shoppingcart, ShoppingcartExtDTO> {

    @Override
    public ShoppingcartExtDTO translate(Shoppingcart invoices) {

        return ShoppingcartExtDTO.builder()
        		.id(invoices.getId())
                .idCustomer(invoices.getIdCustomer())
                .shoppingcartDate(invoices.getShoppingcartDate())
                .totalInvoice(invoices.getTotalInvoice())
                .totalIva(invoices.getTotalIva()).build();
    }

}
