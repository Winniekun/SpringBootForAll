package com.wkk.aop.annotation;

import javax.annotation.security.RunAs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 20-3-10下午4:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
