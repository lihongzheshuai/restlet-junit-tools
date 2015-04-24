package com.coderli.tools.junit.restlet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author li.hzh
 * @date 2015-04-21 14:09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestConfig {

	String url() default "/";

	Class action();

	int port() default 8182;
}
