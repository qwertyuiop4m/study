package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] num = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    num[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                System.out.println(Math.max(num[0][0], num[1][0]));
                continue;
            }

            int[][] dp = new int[2][n];
            dp[0][0] = num[0][0];
            dp[1][0] = num[1][0];
            dp[0][1] = dp[1][0] + num[0][1];
            dp[1][1] = dp[0][0] + num[1][1];

            for (int k = 2; k < n; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + num[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + num[1][k];
            }

            System.out.println(Math.max(dp[1][n - 1], dp[0][n - 1]));
        }
    }
}
