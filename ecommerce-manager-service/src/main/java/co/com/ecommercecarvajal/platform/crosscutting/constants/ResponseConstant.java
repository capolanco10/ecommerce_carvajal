package co.com.ecommercecarvajal.platform.crosscutting.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** @author carlos.penav@carvajal.com */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseConstant {
    public static final String SAVE = "Saving is done ";
    public static final String MESSAGE_RESPONSE = "message";
    public static final String ERROR_FIND = "Search Error";
    public static final String ERROR_COMPANY_FIND = "No se encuentra la informaci\u00F3n asociada a la empresa.";
    public static final String ERROR = "error";
    public static final String ERROR_SAVE = "Save failed";
    public static final String SUCCESSFUL = "successful";
    public static final String DATA = "data";
    public static final String CUSTOMER = "customer";
    public static final String PRODUCT = "product";
    public static final String STATUS = "status";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String FAIL = "failure";
    public static final String ERRORS = "Errors";
    public static final String SPECIFIC_SHIFT_DELIVERY_CENTER = "specificShiftDeliveryCenter";
    public static final String CONFIG_DELIVERY_CENTER_FOR_DAY = "configdeliverycenterforday";
    public static final String ERROR_SEND_NOTIFICATION = "Notificacion no enviada";
    public static final String DATE = "2021-11-03";
    public static final String TIME = "08:30:00";
    public static final String DATE_TIME = "03-11-2021 08:30:00";
    public static final String SWAGGER_LIST = "List";

    /* End-points */
    public static final String CUSTOMERS_URL = "/customers";
    public static final String CUSTOMER_URL = "/customer";
    public static final String PRODUCTS_URL = "/products";
    public static final String PRODUCT_URL = "/product";
    public static final String INVOICE_URL = "/invoice";
}
