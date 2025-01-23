package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2xn_11726 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.println(1);
                return;
            }
            int a = 1; // dp[1]
            int b = 2; // dp[2]
            for (int i = 3; i <= n; i++) {
                int temp = (a + b) % 10007;
                a = b;
                b = temp;
            }
            System.out.println(b);
        }
}
