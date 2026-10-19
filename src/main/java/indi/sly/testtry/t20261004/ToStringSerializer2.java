package indi.sly.testtry.t20261004;

import tools.jackson.databind.annotation.JacksonStdImpl;
import tools.jackson.databind.ser.std.ToStringSerializerBase;

@JacksonStdImpl
public final class ToStringSerializer2
        extends ToStringSerializerBase {
    // Singleton instance to use.
    public final static ToStringSerializer2 instance = new ToStringSerializer2(Object.class);

    // Only needed to support legacy use via annotations
    protected ToStringSerializer2() {
        this(Object.class);
    }

    public ToStringSerializer2(Class<?> handledType) {
        super(handledType);
    }

    @Override
    public String valueToString(Object value) {
        return "LONG" + value.toString();
    }
}
