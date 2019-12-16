package com.agvdcc.core.annotations;

import java.lang.annotation.*;

/**
 * 映射注解
 * 如果有指定的value值，则以该value作为key作为映射关键字
 *
 * @author Laotang
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mapping {
    String value() default "";
}

