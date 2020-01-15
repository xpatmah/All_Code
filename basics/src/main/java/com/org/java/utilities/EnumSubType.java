package com.org.java.utilities;

 class EnumSubType {

	 enum WEEKDAYS{
		
		 MONDAY("MONDAY","Monday"),
		 TUESDAY("TUESDAY","Tuesday"),
		 THURSDAY("THURSDAY","Thursday"),
		 FRIDAY("FRIDAY","Friday");
		 

		 private String key;
		 public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		private String value;
		 
		 private WEEKDAYS(String key,String value) {
			// TODO Auto-generated constructor stub
			 this.key=key;
			 this.value=value;
		}
	 }
	 
	 public static void main(String[] args){
		 
		 for(WEEKDAYS days : WEEKDAYS.values()){
			 System.out.println(days.name());
			 System.out.println(days.getKey());
			 System.out.println(days.getValue());
		
		 }
		 
		
		 
		 
	 }
	 
	 
	 static void call(Integer... i) {
		    
		 
		    System.out.println("hi" + i);
		}

		static void call(int... i) {
		    System.out.println("hello" + i);
		}

}
