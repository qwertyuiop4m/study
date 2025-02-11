package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] W=new int[n+1];
        int[] V=new int[n+1];
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            W[i]=Integer.parseInt(st.nextToken());
            V[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){
            for (int j=1;j<=k;j++){
                if(W[i]>j)dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-W[i]]+V[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
