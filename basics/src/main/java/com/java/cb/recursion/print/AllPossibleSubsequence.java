package com.java.cb.recursion.print;

import java.util.Scanner;

public class AllPossibleSubsequence {

    public static void main(String[] args){
          String toHandle = new Scanner(System.in).nextLine();
          printSubSq(toHandle,"");

    }

    public static void printSubSq(String possibleSubSequence , String subString){
        if (possibleSubSequence.length()==0){
            System.out.print(subString+" ");
            return;
        }
        String remainingString  = String.valueOf(possibleSubSequence.charAt(0));
        String includedInResult = possibleSubSequence.substring(1);
        printSubSq(includedInResult , subString);
        printSubSq(includedInResult , subString.concat(remainingString));

    }
}
