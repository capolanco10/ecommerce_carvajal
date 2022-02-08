package co.com.ecommercecarvajal.platform.crosscutting.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ApiDocumentationConstant
 * 
 * Constantes para documentacion de api
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiDocumentationConstant {

	public static final String POST_VALUE_CUSTOMERS_WEB_API = "Transaccion para agregar un cliente.";
	public static final String POST_NOTE_CUSTOMERS_WEB_API = "Retorna lista de los campos insertados.";

	public static final String GET_VALUE_CUSTOMER_WEB_API = "Transaccion para consultar un cliente.";
	public static final String GET_NOTE_CUSTOMER_WEB_API = "Retorna data del cliente consultado.";

	public static final String GET_VALUE_CUSTOMERS_WEB_API = "Transaccion para consultar todos los clientes.";
	public static final String GET_NOTE_CUSTOMERS_WEB_API = "Retorna una lista de todos los clientes.";

	public static final String DEL_VALUE_CUSTOMER_WEB_API = "Transaccion para eliminar un cliente.";
	public static final String DEL_NOTE_CUSTOMER_WEB_API = 
            "Retorna mensaje de eliminacion del cliente.";

	public static final String POST_VALUE_PRODUCTS_WEB_API = "Transaccion para agregar un producto.";
	public static final String POST_NOTE_PRODUCTS_WEB_API = "Retorna lista de los campos insertados.";

	public static final String GET_VALUE_PRODUCT_WEB_API = "Transaccion para consultar un producto.";
	public static final String GET_NOTE_PRODUCT_WEB_API = "Retorna data del producto consultado.";

	public static final String GET_VALUE_PRODUCTS_WEB_API = "Transaccion para consultar todos los productos.";
	public static final String GET_NOTE_PRODUCTS_WEB_API = "Retorna una lista de todos los productos.";

	public static final String DEL_VALUE_PRODUCT_WEB_API = "Transaccion para eliminar un producto.";
	public static final String DEL_NOTE_PRODUCT_WEB_API = "Retorna mensaje de eliminacion del producto.";
	
	public static final String POST_VALUE_INVOICES_WEB_API = "Transaccion para agregar una factura.";
	public static final String POST_NOTE_INVOICES_WEB_API = "Retorna lista de las facturas insertados.";
}
