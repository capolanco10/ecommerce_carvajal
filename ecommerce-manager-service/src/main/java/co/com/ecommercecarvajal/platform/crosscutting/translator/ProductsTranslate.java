package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Products;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("products")
public class ProductsTranslate implements Translator<ProductsDTO, Products> {

    @Override
    public Products translate(ProductsDTO productsDTO) {

        return Products.builder()
        		.id(productsDTO.getId())
                .code(productsDTO.getCode())
                .name(productsDTO.getName())
                .unitPrice(productsDTO.getUnitPrice())
                .description(productsDTO.getDescription())
                .amount(productsDTO.getAmount()).build();
    }

}
