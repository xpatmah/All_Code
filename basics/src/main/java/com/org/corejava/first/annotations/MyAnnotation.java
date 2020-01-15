package com.org.corejava.first.annotations;

 @interface MyAnnotation {

      String putValue() default "local";
	  int putInt() default 0;
	
}
