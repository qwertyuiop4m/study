package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
  static int N;
  static int M;
  static int[][] tomato;
  static int count=0;
  static int[] dx={-1,0,1,0};
  static int[] dy={0,-1,0,1};
  static Queue<int[]> q=new LinkedList<int[]>();
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer=new StringTokenizer(bf.readLine());

    M=Integer.parseInt(stringTokenizer.nextToken());
    N=Integer.parseInt(stringTokenizer.nextToken());

    tomato=new int[N][M];
    for (int i = 0; i < N; i++) {
      stringTokenizer=new StringTokenizer(bf.readLine());
      for (int j = 0; j < M; j++) {
        tomato[i][j]=Integer.parseInt(stringTokenizer.nextToken());
        if(tomato[i][j]==1){
          q.add(new int[]{i,j});
        }
      }
    }
    System.out.println(bfs());
  }

  private static int bfs() {
    while (!q.isEmpty()) {
      int[] temp = q.poll();
      int x = temp[0];
      int y = temp[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (tomato[nx][ny] == 0) {
            q.add(new int[]{nx, ny});
            tomato[nx][ny] = tomato[x][y] + 1;
          }
        }
      }
    }

    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (tomato[i][j] == 0) {
          return -1;
        }
        maxDay = Math.max(maxDay, tomato[i][j]);
      }
    }
    return maxDay - 1;
  }
}
