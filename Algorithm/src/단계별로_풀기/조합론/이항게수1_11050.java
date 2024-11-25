package 단계별로_풀기.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항게수1_11050 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        dp=new int[n+1][k+1];
        System.out.println(bc(n, k));
    }
    static int bc(int n, int k){
        if(dp[n][k]>0){
            return dp[n][k];
        }
        if(n==k||k==0)return dp[n][k]=1;
        return dp[n][k]=bc(n-1,k-1)+bc(n-1,k);
    }
}
