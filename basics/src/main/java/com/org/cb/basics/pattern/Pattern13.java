package com.org.cb.basics.pattern;

import java.util.Scanner;

// 2n-1 pattern
public class Pattern13 {

    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();
        int totalNoOfRows = ((2*n) -1);
        int noOfStars = n-1;
        int  noOfSpace = 1;
        for(int i = 0 ; i < totalNoOfRows ; i++){
          // Work Done in each Row
          for(int j = 0 ; j < noOfStars ; j++) {
            System.out.print("*");
          }
          for(int k = 0 ; k < noOfSpace ; k++) {
              System.out.print(" ");
          }
          for(int j = 0 ; j < noOfStars ; j++) {
                System.out.print("*");
          }
          //Preparation for the next row
          System.out.println();
          if(i < totalNoOfRows/2){
              noOfStars--;
              noOfSpace = noOfSpace+2;
          }else{
              noOfStars++;
              noOfSpace = noOfSpace-2;
          }
        }
    }

}
