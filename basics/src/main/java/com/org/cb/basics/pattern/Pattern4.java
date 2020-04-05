package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern4 {

    public static void main(String[] args){
         int noOfRows = new Scanner(System.in).nextInt();
         for(int i = noOfRows ; i > 0 ;i--){
                // Work That needs to be done
                for(int j =0  ; j < i-1 ; j++){
                     System.out.print(" ");
                }
                for(int k = 0 ; k <= noOfRows-i ; k++){
                    System.out.print("*");
                }
                // Preparation of the next row
                System.out.println();
         }

    }
}
