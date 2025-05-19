package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길_1520 {
  static int[] dx={-1,1,0,0};
  static int[] dy={0,0,-1,1};
  static int[][] arr,dp;
  static int n,m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    m=Integer.parseInt(st.nextToken());
    n=Integer.parseInt(st.nextToken());
    arr=new int[m][n];
    dp=new int[m][n];
    for(int i=0;i<m;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
        dp[i][j]=-1;
      }
    }

    System.out.println(dfs(0,0));
  }

  private static int dfs(int x, int y) {
    if(x==m-1 && y==n-1){
      return 1;
    }
    if(dp[x][y]!=-1) return dp[x][y];
    dp[x][y]=0;
    for(int i=0;i<4;i++){
      int nx=x+dx[i];
      int ny=y+dy[i];
      if(nx<0||ny<0||nx>=m||ny>=n)continue;
      if(arr[nx][ny]<arr[x][y]){
        dp[x][y]+=dfs(nx,ny);
      }
    }
    return dp[x][y];
  }
}
