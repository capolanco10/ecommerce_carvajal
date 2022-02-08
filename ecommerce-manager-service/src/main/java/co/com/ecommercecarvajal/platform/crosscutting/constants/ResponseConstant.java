package co.com.ecommercecarvajal.platform.crosscutting.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** @author carlos.penav@carvajal.com */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseConstant {
   
    public static final String SUCCESSFUL = "successful";
    public static final String CUSTOMER = "customer";
    public static final String PRODUCT = "product";
    public static final String STATUS = "status";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String FAIL = "failure";
    public static final String ERRORS = "Errors";
    public static final String SWAGGER_LIST = "List";

    /* End-points */
    public static final String CUSTOMERS_URL = "/customers";
    public static final String CUSTOMER_URL = "/customer";
    public static final String PRODUCTS_URL = "/products";
    public static final String PRODUCT_URL = "/product";
    public static final String INVOICE_URL = "/shoppingcart";
}
