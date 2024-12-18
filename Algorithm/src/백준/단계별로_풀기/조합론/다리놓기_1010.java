package 백준.단계별로_풀기.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            dp=new int[m+1][n+1];
            System.out.println(bc(m,n));
        }
    }

    private static int bc(int m, int n) {
        if(dp[m][n]>0)return dp[m][n];
        if(n==m||n==0) return dp[m][n]=1;
        return dp[m][n]=bc(m-1,n-1)+bc(m-1,n);
    }
}
