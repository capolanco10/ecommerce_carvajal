package co.com.ecommercecarvajal.platform.crosscutting.translator;

import org.springframework.beans.factory.annotation.Qualifier;

import co.com.ecommercecarvajal.platform.crosscutting.domain.ProductsDTO;
import co.com.ecommercecarvajal.platform.crosscutting.patterns.Translator;
import co.com.ecommercecarvajal.platform.crosscutting.persistence.entity.Products;
import co.com.ecommercecarvajal.platform.crosscutting.stereotypes.DomainTranslator;

@DomainTranslator
@Qualifier("productsDTO")
public class ProductsDTOTranslate implements Translator<Products, ProductsDTO> {

    @Override
    public ProductsDTO translate(Products entity) {

        return ProductsDTO.builder()
        		.id(entity.getId())
                .code(entity.getCode())
                .unitPrice(entity.getUnitPrice())
                .description(entity.getDescription()).build();
    }

}
