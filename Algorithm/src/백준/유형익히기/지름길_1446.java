package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 지름길_1446 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][3];
    int[] dp = new int[d + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[2]));

    for (int i = 0; i <= d; i++) {
      if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
      for (int[] sc : arr) {
        int start = sc[0];
        int end = sc[1];
        int cost = sc[2];
        if (start == i && end <= d) {
          dp[end] = Math.min(dp[end], dp[i] + cost);
        }
      }
    }
    System.out.println(dp[d]);
  }
}
