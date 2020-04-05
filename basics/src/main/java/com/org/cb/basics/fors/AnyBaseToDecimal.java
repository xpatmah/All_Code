package com.org.cb.basics.fors;

import java.util.Scanner;

public class AnyBaseToDecimal {

    public static void main(String[] args){

        System.out.println("Enter the no to convert :-");
        int noToConvert = new Scanner(System.in).nextInt();
        System.out.println("Enter the base of the no :-");
        int baseOfTheNo = new Scanner(System.in).nextInt();

        int count = 0;
        int result = 0;

        while(noToConvert > 0){
            int remainDer = noToConvert % 10;
            result = result + (remainDer * (int)Math.pow(baseOfTheNo, count));
            noToConvert = noToConvert/10;
            count++;
        }
        System.out.println(result);

    }
}
