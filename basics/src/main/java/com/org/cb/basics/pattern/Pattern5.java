package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern5 {

    public static void main(String[] args){

        int noOfRows = new Scanner(System.in).nextInt();

        for(int i = 0 ; i < noOfRows ; i++){
            // Work Needs to be done
            for(int j = 0 ; j < i ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < noOfRows-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
