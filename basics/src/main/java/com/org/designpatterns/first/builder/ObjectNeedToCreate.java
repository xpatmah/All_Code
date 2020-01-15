package com.org.designpatterns.first.builder;

public class ObjectNeedToCreate {

     private String property1;
	
	@Override
	public String toString() {
		return "ObjectNeedToCreate [property1=" + property1 + ", property2=" + property2 + ", property3=" + property3
				+ ", property4=" + property4 + "]";
	}

	private String property2;
     
     private String property3;
     
     private String property4;
     
     private ObjectNeedToCreate(ObjectBuilder obj) {
    	 property1  = obj.property1;
    	 property2 = obj.property2;
    	 property3 = obj.property3;
    	 property4 = obj.property4;
     }
     
     public static class ObjectBuilder{
    	 	
    	 private String property1;
    		
    		private String property2;
    	     
    	     private String property3;
    	     
    	     private String property4;
    	 
    	 public ObjectNeedToCreate build() {
    		 return new ObjectNeedToCreate(this);
    	 }
    	 
    	 public ObjectBuilder needPropert1(String property1) {
    		 this.property1 = property1;
    		 return this;
    	 }
    	 
    	 public ObjectBuilder needPropert2(String property2) {
    		 this.property2 = property2;
    		 return this;
    	 }
    	 
    	 public ObjectBuilder needPropert3(String property3) {
    		 this.property3 = property3;
    		 return this;
    	 }
    	 
    	 public ObjectBuilder needPropert4(String property4) {
    		 this.property4 = property4;
    		 return this;
    	 }
    	 
     }
     
     public String getProperty1() {
 		return property1;
 	}

 	public String getProperty2() {
 		return property2;
 	}

 	public String getProperty3() {
 		return property3;
 	}

 	public String getProperty4() {
 		return property4;
 	}
     
     
     
}
