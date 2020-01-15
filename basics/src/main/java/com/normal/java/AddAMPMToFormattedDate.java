package com.normal.java;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddAMPMToFormattedDate {
 
  public static void main(String[] args) {
 
    //create Date object
    Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.set(Calendar.HOUR, 11);
    c.set(Calendar.MINUTE, 15);
    c.set(Calendar.AM_PM, Calendar.AM);  
    c.add(Calendar.MINUTE,75);
     //formatting time to have AM/PM text using 'a' format
     String strDateFormat = "HH:mm aa";
     SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
     
     System.out.println("Time with AM/PM field : " + sdf.format(c.getTime()));
 
  }
}