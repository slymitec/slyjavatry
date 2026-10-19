package indi.sly.testtry.t20250614;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodScope {
    long value() default MethodScopeType.KERNEL_AND_SERVICE;
}
