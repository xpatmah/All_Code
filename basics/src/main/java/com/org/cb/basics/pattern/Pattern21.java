package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern21 {

    public static void main(String[] args){
        int noOfRows = new Scanner(System.in).nextInt();

        for(int i = 0 ; i < noOfRows ; i ++){
            // Work Done in Each Row
            if(i!=noOfRows-1){
                for(int j = 0 ; j<i+1;j++){
                    System.out.print("*");
                }
                for(int k = 0 ; k < ((2*noOfRows) - 1)- 2*(i+1) ; k++){
                    System.out.print(" ");
                }
                for(int j = 0 ; j<i+1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }else {
                for (int m = 0; m < ((2 * noOfRows) - 1); m++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            // Preparation for the next row
        }


    }
}
