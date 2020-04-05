package com.java.cb.recursion.print;

import java.util.Scanner;

public class AllPermutaiton {

    public static void main(String[] args){
          String printAllThePermutation = new Scanner(System.in).nextLine();

    }

    public static void printAllThePermutation(String allPermutations , String permutations){
              if(permutations.length()==allPermutations.length()){
                  System.out.println(permutations);
              }

              String firstChar = allPermutations.charAt(0)+"";
              String reMainingString = allPermutations.substring(1);
              printAllThePermutation(reMainingString,firstChar.concat(permutations));
    }
}

