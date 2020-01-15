package com.normal.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateExample1 {

    public static void main(String[] argv) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}