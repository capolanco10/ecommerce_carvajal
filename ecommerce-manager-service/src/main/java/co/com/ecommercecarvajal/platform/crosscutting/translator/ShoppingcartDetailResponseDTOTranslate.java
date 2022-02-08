package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailResponseDTO;
import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartExtDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("shoppingcartDetailResponseDTO")
public class ShoppingcartDetailResponseDTOTranslate implements Translator<ShoppingcartExtDTO, ShoppingcartDetailResponseDTO> {

    @Override
    public ShoppingcartDetailResponseDTO translate(ShoppingcartExtDTO entity) {

        return ShoppingcartDetailResponseDTO.builder()
        		.id(entity.getId())
                .idCustomer(entity.getIdCustomer())
                .shoppingcartDate(entity.getShoppingcartDate())
                .totalInvoice(entity.getTotalInvoice())
                .totalIva(entity.getTotalIva()).build();
    }

}
