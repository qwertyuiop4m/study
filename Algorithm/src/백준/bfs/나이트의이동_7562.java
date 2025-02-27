package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
  static int x1,x2,y1,y2,n;
  static int[] dx={1,2,1,2,-1,-2,-1,-2};
  static int[] dy={-2,-1,2,1,-2,-1,2,1};
  static int[][] arr;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      x2 = Integer.parseInt(st1.nextToken());
      y2 = Integer.parseInt(st1.nextToken());
      arr=new int[n][n];
      visited=new boolean[n][n];
      bfs();
      System.out.println(arr[x2][y2]);
    }
  }

  private static void bfs() {
    Queue<int[]> q=new LinkedList<>();
    q.add(new int[]{x1,y1});
    visited[x1][y1]=true;
    while(!q.isEmpty()){
      int[] temp=q.poll();
      int x=temp[0];
      int y=temp[1];
      for(int i=0;i<8;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx>=0&&nx<n&&ny>=0&&ny<n){
          if(!visited[nx][ny]){
            q.add(new int[]{nx,ny});
            arr[nx][ny]=arr[x][y]+1;
            visited[nx][ny]=true;
          }
        }
      }
    }
  }
}
