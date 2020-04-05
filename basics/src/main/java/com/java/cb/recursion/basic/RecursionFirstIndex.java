package com.java.cb.recursion.basic;

public class RecursionFirstIndex {


    public static void main(String[] args) {
        int[] array = {2, 3, 45, 1, 4, 67, 1, 1, 6};
        System.out.println(getFirstIndex(array,0,2));
    }

    public static int getFirstIndex(int[] array, int startIndex, int noTosearch) {
         if(startIndex==array.length){
             return -1;
         }
         if(array[startIndex] == noTosearch){
             return startIndex;
         }
         return getFirstIndex(array , startIndex+1, noTosearch);
    }
}
