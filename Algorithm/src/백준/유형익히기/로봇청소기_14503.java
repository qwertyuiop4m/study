package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
  static int N,M;
  static int[][] map;
  static boolean[][] visited;
  static int count=0;
  static int[] dx={-1,0,1,0};
  static int[] dy={0,1,0,-1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    st = new StringTokenizer(br.readLine());
    int start_x=Integer.parseInt(st.nextToken());
    int start_y=Integer.parseInt(st.nextToken());
    int d=Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(start_x,start_y,d);
    System.out.println(count);
  }

  private static void dfs(int x, int y,int d) {
    if (!visited[x][y]) {
      visited[x][y] = true;
      count++;
    }
    for (int i = 0; i < 4; i++) {
      d=(d+3)%4;
      int next_x=x+dx[d];
      int next_y=y+dy[d];
      if(next_x>=0&&next_x<N&&next_y>=0&&next_y<M&&map[next_x][next_y]==0){
       if(!visited[next_x][next_y]){
         dfs(next_x,next_y,d);
         return;
       }
      }
    }
    int back_d=(d+2)%4;
    int bx=x+dx[back_d];
    int by=y+dy[back_d];
    if (bx>=0&&by>=0&&bx<N&&by<M&&map[bx][by]!=1){
      dfs(bx,by,d);
    }
  }
}
