package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {
  static int n,m;
  static int[][] map;
  static int[][] result;
  static boolean[][] visited;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    n=Integer.parseInt(st.nextToken());
    m=Integer.parseInt(st.nextToken());
    map=new int[n][m];
    result=new int[n][m];
    visited=new boolean[n][m];
    int startx=-1,straty=-1;
    for (int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      for (int j=0;j<m;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
        if(map[i][j]==2){
          startx=i;
          straty=j;
        }
        if(map[i][j]==1){
          result[i][j]=-1;
        }
      }
    }
    bfs(startx,straty);

    for (int i=0;i<n;i++){
      for (int j=0;j<m;j++){
        System.out.print(result[i][j]+" ");
      }
      System.out.println();
    }
  }

  private static void bfs(int x,int y) {
    Queue<int[]> q=new LinkedList<>();
    q.offer(new int[]{x,y});
    visited[x][y]=true;
    result[x][y]=0;

    while (!q.isEmpty()){
      int[] temp=q.poll();
      int current_x=temp[0];
      int current_y=temp[1];
      for (int i=0;i<4;i++){
        int nx=current_x+dx[i];
        int ny=current_y+dy[i];
        if(nx>=0&&nx<n&&ny>=0&&ny<m){
          if(map[nx][ny]==1&&!visited[nx][ny]){
            visited[nx][ny]=true;
            result[nx][ny]=result[current_x][current_y]+1;
            q.add(new int[]{nx,ny});
          }
        }
      }
    }
  }
}
