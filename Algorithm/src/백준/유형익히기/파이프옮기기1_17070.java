package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 파이프옮기기1_17070 {
    static int n;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(dfs(0, 1, 0));
    }

    private static int dfs(int x, int y, int dir) {
        if (x == n - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y][dir] != -1) return dp[x][y][dir];

        dp[x][y][dir] = 0;

        //0가로,1세로,대각선
        if (dir == 0 || dir == 2) {
            if (y + 1 < n && map[x][y + 1] == 0) {
                dp[x][y][dir] += dfs(x, y + 1, 0);
            }
        }
        if (dir == 1 || dir == 2) {
            if (x + 1 < n && map[x + 1][y] == 0) {
                dp[x][y][dir] += dfs(x + 1, y, 1);
            }
        }
        if (x + 1 < n && y + 1 < n) {
            if (map[x + 1][y + 1] == 0 && map[x + 1][y] == 0 && map[x][y + 1] == 0) {
                dp[x][y][dir] += dfs(x + 1, y + 1, 2);
            }
        }

        return dp[x][y][dir];
    }
}
