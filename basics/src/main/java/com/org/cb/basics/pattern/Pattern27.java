package com.org.cb.basics.pattern;

import java.util.Scanner;

public class Pattern27 {

    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();

        for(int i =0 ; i < n  ; i++){
            for(int j = 0 ; j < n-i-1 ; j ++){
                System.out.print("\t");
            }
            int count = 0;
            for(int k =0 ; k < 2*i+1 ; k++){
                if(k <= i){
                    System.out.print(++count+"\t");
                }else{
                    System.out.print(--count+"\t");
                }
            }
            System.out.println();
        }

    }

}
