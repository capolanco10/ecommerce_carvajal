package co.com.ecommercecarvajal.platform.crosscutting.util;
import java.lang.reflect.Type;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.ecommercecarvajal.platform.crosscutting.constants.Constants;
import lombok.experimental.UtilityClass;

/**
 * Utileria para el manejo de Gson
 *
 * @author carvajal
 */
@UtilityClass
public class JsonUtils {

    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setDateFormat(Constants.SIMPLE_DATE_FORMAT)
            .setPrettyPrinting()
            .create();

    public static String toJson(final Object obj) {
        return GSON.toJson(obj);
    }

    public static <T extends Object> T fromJson(final String json, final Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    public static <T extends Object> T fromJsonType(final String json, final Type typeOf) {
        return GSON.fromJson(json, typeOf);
    }
}
