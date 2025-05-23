package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCW_11758 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[3][2];
    for (int i = 0; i < 3; i++) {
      StringTokenizer st=new StringTokenizer(br.readLine());
      arr[i][0]=Integer.parseInt(st.nextToken());
      arr[i][1]=Integer.parseInt(st.nextToken());
    }
    int x1=arr[0][0],y1=arr[0][1];
    int x2=arr[1][0],y2=arr[1][1];
    int x3=arr[2][0],y3=arr[2][1];
    int ccw=(x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
    if (ccw < 0) {
      System.out.println(-1);
    }else if (ccw > 0) {
      System.out.println(1);
    }else{
      System.out.println(0);
    }
  }
}
