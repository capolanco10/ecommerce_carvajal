package co.com.ecommercecarvajal.platform.crosscutting.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public final class CheckUtil {

    private CheckUtil() {
        super();
    }

    public static String checkNullString(final String input) {
        return input == null ? "" : input;
    }

    public static Long checkNullLong(final Object input) {
        return input == null ? 0L : Long.parseLong(input.toString());
    }

    public static Date checkNullDate(final Date input) {
        return input == null ? new Date() : input;
    }

    public static String checkNullLongToString(final Long input) {
        return input == null ? "" : Long.toString(input);

    }

    public static String checkFullName(final String firstName,
            final String secondName, final String firstSurname,
            final String secondSurname) {

        String fullName = firstName.concat(" ");

        if (!StringUtils.isBlank(secondName))
            fullName = fullName.concat(secondName).concat(" ");

        fullName = fullName.concat(firstSurname);

        if (!StringUtils.isBlank(secondSurname))
            fullName = fullName.concat(" ").concat(secondSurname);

        return fullName;
    }

}
