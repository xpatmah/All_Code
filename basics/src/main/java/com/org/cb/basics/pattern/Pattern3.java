package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern3 {

    public static void main(String[] args){
           int noOfRows = new Scanner(System.in).nextInt();
           int noOFStars = noOfRows;
           for (int i = 0 ; i < noOfRows ; i++){
              // Work Done in each row
               for(int j = 0 ; i< noOFStars ; j ++){
                   System.out.println("*");
               }
             // Preparation of next row
             System.out.println();
             noOFStars--;
           }
    }
}
