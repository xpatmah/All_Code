package com.org.problemsolving.dp.second.intro;

public class Febo {

    public static void main(String[] args){
        Febo f = new Febo();
        int[] dp = new int[5];
        System.out.println(f.fibo(5,dp));
    }

    private int fibo(int n,int[] dp){
        if(n==0 || n ==1){
             return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
        return dp[n];
    }
}
