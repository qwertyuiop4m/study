package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
  static int M,N,H;
  static int[][][] tomato;
  static int[] dx = {-1,0,1,0,0,0};
  static int[] dy = {0,-1,0,1,0,0};
  static int[] dz= {0,0,0,0,-1,1};
  static Queue<int[]> q = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    M=Integer.parseInt(st.nextToken());
    N=Integer.parseInt(st.nextToken());
    H=Integer.parseInt(st.nextToken());
    tomato=new int[H][N][M];
    for(int i=0;i<H;i++){
      for(int j=0;j<N;j++){
        st=new StringTokenizer(br.readLine());
        for(int k=0;k<M;k++){
          tomato[i][j][k]=Integer.parseInt(st.nextToken());
          if(tomato[i][j][k]==1){
            q.add(new int[]{i,j,k});
          }
        }
      }
    }
    System.out.println(bfs());
  }
  private static int bfs() {
    while(!q.isEmpty()){
      int[] temp=q.poll();
      int x=temp[0],y=temp[1],z=temp[2];
      for(int i=0;i<6;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        int nz=z+dz[i];
        if(nx >= 0 && ny >= 0 && nx < H && ny < N&&nz >= 0 && nz < M){
          if(tomato[nx][ny][nz]==0){
            q.add(new int[]{nx,ny,nz});
            tomato[nx][ny][nz]=tomato[x][y][z]+1;
          }
        }
      }
    }
    int max=0;
    for(int i=0;i<H;i++){
      for(int j=0;j<N;j++){
        for(int k=0;k<M;k++){
          if(tomato[i][j][k]==0){
            return -1;
          }
          max=Math.max(max,tomato[i][j][k]);
        }
      }
    }
    return max-1;
  }
}
