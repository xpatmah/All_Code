package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern23 {

    public static void main(String[] args){
        int noOfRows = new Scanner(System.in).nextInt();
        int counter = 1;
        for(int i = 0 ; i < noOfRows ; i ++){
            // Work Done in each row
            for(int j = 0 ; j < noOfRows-(i+1); j++){
                System.out.print("\t");
            }
            for(int k = 0 ; k < (2*i + 1); k ++){
                System.out.print(counter+"\t");
                counter++;
            }
            // Preparation of the next row
            System.out.println();

        }


    }
}
