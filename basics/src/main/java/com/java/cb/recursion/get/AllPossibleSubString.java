package com.java.cb.recursion.get;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AllPossibleSubString {

    public static void main(String[] args){
        String stringToGetSubString = new Scanner(System.in).nextLine();
        System.out.println(getAllPossibleString(stringToGetSubString));
    }


    private static List<String> getAllPossibleString(String stringToGetSubString){
              if(null==stringToGetSubString || stringToGetSubString.length()==0){
                  List<String> arrayList = new ArrayList<>();
                  arrayList.add("");
                  return arrayList;
              }
               List<String> subString = getAllPossibleString(stringToGetSubString.substring(1,stringToGetSubString.length()));
               String additions = stringToGetSubString.substring(0,1);
               List<String> finalSetOfString =  subString.stream().map(additions::concat).collect(Collectors.toList());
               subString.addAll(finalSetOfString);
               Collections.sort(subString);
               return subString;
    }
}
