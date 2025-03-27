package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_2447 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb=new StringBuilder();
    int n=Integer.parseInt(br.readLine());
    for(int i=0;i<n;i++){
      for (int j=0;j<n;j++){
        sb.append(isBlank(i,j)?' ':'*');
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }

  private static boolean isBlank(int i, int j) {
    while (i>0||j>0) {
      if (i%3==1&&j%3==1)return true;
      i/=3;
      j/=3;
    }
    return false;
  }
}
