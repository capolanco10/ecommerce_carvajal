package co.com.ecommercecarvajal.platform.crosscutting.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constantes
 *
 * @author carvajal
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final Integer ADDED_TIME_START_BLOKADE = 60;
    public static final String SIMPLE_DATE_FORMAT = "dd-MM-yyyy";
    public static final String SIMPLE_TIME_FORMAT = "HH:mm:ss";
    public static final String SIMPLE_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String ISO_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String LOCALE_LANGUAGE = "locale.language";
    public static final String LOCALE_COUNTRY = "locale.country";
}
