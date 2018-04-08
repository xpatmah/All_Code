package com.org.java.annotations;

 @interface MyAnnotation {

      String putValue() default "local";
	  int putInt() default 0;
	
}
