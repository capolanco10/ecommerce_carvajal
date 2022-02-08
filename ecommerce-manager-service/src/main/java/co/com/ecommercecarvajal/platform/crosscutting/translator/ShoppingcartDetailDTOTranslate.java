package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ShoppingcartDetailDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.ShoppingcartDetail;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("shoppingcartDetailDTO")
public class ShoppingcartDetailDTOTranslate implements Translator<ShoppingcartDetail, ShoppingcartDetailDTO> {

    @Override
    public ShoppingcartDetailDTO translate(ShoppingcartDetail entity) {

        return ShoppingcartDetailDTO.builder()
        		.id(entity.getId())
                .idShoppingcart(entity.getIdShoppingcart())
                .idProduct(entity.getIdProduct())
                .amount(entity.getAmount())
                .subtotal(entity.getSubtotal())
                .total(entity.getTotal()).build();
    }

}
