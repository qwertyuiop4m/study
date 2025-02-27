package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기_11403 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[][] arr=new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st=new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if(arr[j][i]==1&&arr[i][k]==1){
            arr[j][k]=1;
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }
  }
}
