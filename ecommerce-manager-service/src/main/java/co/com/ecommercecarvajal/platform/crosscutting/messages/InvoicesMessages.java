package co.com.ecommercecarvajal.platform.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvoicesMessages {
	
    public static final String PRODUCTS_ERROR_SAVE = "Error guardando los productos";
    
    public static final String COD_PRODUCT_ERROR = "CD001";
    public static final String GET_PRODUCT_ERROR = "Error buscando producto";

    public static final String DELETE_PRODUCT = "Se elimin� el producto con exito.";
}
