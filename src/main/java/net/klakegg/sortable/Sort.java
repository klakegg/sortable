package net.klakegg.sortable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for declaring a value used for comparison.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Sort {

    /**
     * Value used to compare.
     *
     * @return Value used to compare.
     */
    int value() default 0;
}