package co.com.ecommercecarvajal.platform.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsMessages {
	
    public static final String PRODUCTS_ERROR_SAVE = "Error guardando los productos";
    
    public static final String COD_PRODUCT_ERROR = "CD001";
    public static final String GET_PRODUCT_ERROR = "Error buscando producto";

    public static final String DELETE_PRODUCT = "Se elimino el producto con exito.";
    public static final String PRODUCT_NOTNULL = "El id del producto no puede ser nulo.";
    
    public static final String DELETE_SHOPPINGCARTDETAIL= "Se elimino el producto de la lista de deseo con exito.";
}
