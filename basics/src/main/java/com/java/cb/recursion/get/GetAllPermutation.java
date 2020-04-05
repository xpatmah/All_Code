package com.java.cb.recursion.get;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetAllPermutation {

    public static void main(String[] args){
          String newStringToManupulate = new Scanner(System.in).nextLine();
          System.out.println(getAllThePermutationOfString(newStringToManupulate));
    }


    public static List<String> getAllThePermutationOfString(String permutationString){
        if(null!=permutationString && permutationString.length()==0){
              return new ArrayList<>();
          }

          if(permutationString.length()==1){
              List<String> arrayList =  new ArrayList<>();
              arrayList.add(permutationString);
              return arrayList;
          }
          List<String> newSubList = new ArrayList<>();
          List<String> allSubString =  getAllThePermutationOfString(permutationString.substring(1,permutationString.length()));
          String subString = permutationString.substring(0,1);
          for(String str : allSubString){
              newSubList.add(subString.concat(str));
              newSubList.add(str.concat(subString));
          }

          return newSubList;
    }
}
