package 백준.단계별로_풀기.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] num=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = num[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(num[i], dp[i - 1] + num[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
