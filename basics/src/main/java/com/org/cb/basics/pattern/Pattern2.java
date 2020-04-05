package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern2 {

    public static void main(String[] args){
         int n = new Scanner(System.in).nextInt();
         int noOfStars = 1;
         for(int i = 0 ; i < n ; i ++){
             int count  = 0;
             // Work needs to be done in one Row
             while(count < noOfStars){
                 System.out.print("*");
                 count++;
             }
             // Preparation of the next row
             System.out.println();
             noOfStars++;
         }


    }

}
