package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨_1389 {
  static final int INF=99999999;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr=new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = INF;
        if(i==j)arr[i][j]=0;
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[x][y] = arr[y][x]=1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          if(arr[j][k]>arr[j][i]+arr[i][k]){
            arr[j][k]=arr[j][i]+arr[i][k];
          }
        }
      }
    }
    int result=Integer.MAX_VALUE;
    int min=0;
    for (int i=1;i<=n;i++){
      int temp=0;
      for (int j=1;j<=n;j++){
        if(arr[i][j]==INF)continue;
        temp+=arr[i][j];
      }
      if(result>temp){
        result=temp;
        min=i;
      }
    }
    System.out.println(min);
  }
}
