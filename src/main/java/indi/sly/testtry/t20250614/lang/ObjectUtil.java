package indi.sly.testtry.t20250614.lang;

public class ObjectUtil {
    public static boolean isAnyNull(final Object value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAnyNull(final Object... values) {
        if (values == null || values.length == 0) {
            return true;
        } else {
            for (Object value : values) {
                if (value == null) {
                    return true;
                }
            }
            return false;
        }
    }
}
