package indi.sly.testtry.t20261013;

import org.jspecify.annotations.Nullable;

public abstract class ObjectUtil {
    public static boolean isNull(@Nullable final Object value) {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAnyNull(@Nullable final Object @Nullable [] values) {
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

    public static boolean isAnyNull(@Nullable final Object value1, @Nullable final Object @Nullable [] values) {
        if (value1 == null || values == null) {
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

    public static boolean isAnyNull(@Nullable final Object value1, @Nullable final Object value2, @Nullable final Object... values) {
        if (value1 == null || value2 == null) {
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

    public static boolean notNull(@Nullable final Object value) {
        if (value == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean allNotNull(@Nullable final Object @Nullable [] values) {
        if (values == null || values.length == 0) {
            return false;
        } else {
            for (Object value : values) {
                if (value == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean allNotNull(@Nullable final Object value1, @Nullable final Object value2, @Nullable final Object... values) {
        if (value1 == null || value2 == null) {
            return false;
        } else {
            for (Object value : values) {
                if (value == null) {
                    return false;
                }
            }
            return true;
        }
    }
}