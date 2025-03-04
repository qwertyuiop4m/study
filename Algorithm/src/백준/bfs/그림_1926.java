package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926 {
  static int n,m;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx={-1,0,1,0};
  static int[] dy={0,-1,0,1};
  static int count=0;
  static int max=Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(bf.readLine());

    n=Integer.parseInt(st.nextToken());
    m=Integer.parseInt(st.nextToken());

    map=new int[n][m];
    visited=new boolean[n][m];
    for (int i=0;i<n;i++){
      st=new StringTokenizer(bf.readLine());
      for (int j=0;j<m;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    for (int i=0;i<n;i++){
      for (int j=0;j<m;j++){
        if (map[i][j]==1&& !visited[i][j]){
          count++;
          max=Math.max(max,bfs(i,j));
        }
      }
    }
    System.out.println(count);
    System.out.println(max);
  }

  private static int bfs(int x ,int y) {
    Queue<int[]> q=new LinkedList<>();
    q.add(new int[]{x,y});
    visited[x][y]=true;

    int size=1;
    while (!q.isEmpty()){
      int[] a=q.poll();
      int current_x=a[0],current_y=a[1];
      for (int i=0;i<4;i++){
        int nx=current_x+dx[i],ny=current_y+dy[i];
        if(nx>=0&&nx<n&&ny>=0&&ny<m){
          if(map[nx][ny]==1&&!visited[nx][ny]){
            visited[nx][ny]=true;
            q.add(new int[]{nx,ny});
            size++;
          }
        }
      }
    }
    return size;
  }
}
