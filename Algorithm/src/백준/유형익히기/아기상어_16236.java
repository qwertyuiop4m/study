package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class 아기상어_16236 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    static int sx, sy;
    static int time = 0;
    static int size = 2;
    static int eaten = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            int[] target = bfs();
            if (target == null) break;

            int tx = target[0];
            int ty = target[1];
            int dist = target[2];

            time += dist;
            sx = tx;
            sy = ty;

            map[tx][ty] = 0;
            eaten++;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        System.out.println(time);
    }

    private static int[] bfs() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        int minDist = Integer.MAX_VALUE;
        int tx = -1;
        int ty = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (dist[x][y] > minDist) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (dist[nx][ny] != -1) continue;

                if (map[nx][ny] <= size) {
                    dist[nx][ny] = dist[x][y] + 1;

                    if (map[nx][ny] > 0 && map[nx][ny] < size) {
                        int d = dist[nx][ny];
                        if (d < minDist) {
                            minDist = d;
                            tx = nx;
                            ty = ny;
                        } else if (d == minDist) {
                            if (nx < tx || (nx == tx && ny < ty)) {
                                tx = nx;
                                ty = ny;
                            }
                        }
                    }
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (tx == -1) return null;
        return new int[]{tx, ty, minDist};
    }
}
