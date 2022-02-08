package co.com.ecommercecarvajal.platform.crosscutting.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomersMessages {
	
    public static final String CUSTOMERS_ERROR_SAVE = "Error guardando los clientes";
    
    public static final String COD_CUSTOMER_ERROR = "CD001";
    public static final String GET_CUSTOMER_ERROR = "Error buscando cliente";

    public static final String DELETE_CUSTOMER = "Se eliminó el cliente con exito.";
    public static final String CUSTOMER_NOTNULL = "El id del cliente no puede ser nulo.";
}
