package com.org.corejava.first.innner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Overannotation {

	public String Local() default "local";
	
	public int value() default 100;
}
