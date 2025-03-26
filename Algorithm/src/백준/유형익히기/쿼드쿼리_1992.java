package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드쿼리_1992 {
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String line=br.readLine();
      for (int j = 0; j < n; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }
    divide(0,0,n);
  }

  private static void divide(int x, int y, int size) {
    if(isSame(x,y,size)){
      System.out.print(arr[x][y]);
    }else {
      System.out.print("(");
      divide(x,y,size/2);
      divide(x,y+size/2,size/2);
      divide(x+size/2,y,size/2);
      divide(x+size/2,y+size/2,size/2);
      System.out.print(")");
    }
  }

  private static boolean isSame(int x, int y, int size) {
    int value=arr[x][y];
    for(int i=x;i<x+size;i++){
      for(int j=y;j<y+size;j++){
        if(value!=arr[i][j]) return false;
      }
    }
    return true;
  }
}
