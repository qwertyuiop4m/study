package 백준.단계별로_풀기.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열1_24416 {
    static int[] dp;
    static int a=0;
    static int b=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        dp=new int[n+1];
        fib(n);
        fibonacci(n);
        System.out.println(b+" "+a);
    }

    private static int fibonacci(int n) {
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
            a++;
        }
        return dp[n];
    }

    private static int fib(int n) {
        if(n==1||n==2) {
            b++;
            return 1;
        }
        else{
            return(fib(n-1)+fib(n-2));
        }
    }
}
