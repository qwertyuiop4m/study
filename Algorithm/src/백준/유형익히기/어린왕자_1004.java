package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어린왕자_1004 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    for(int i=0;i<t;i++){
      int result=0;
      StringTokenizer st=new StringTokenizer(br.readLine());
      int start_x = Integer.parseInt(st.nextToken());
      int start_y = Integer.parseInt(st.nextToken());
      int end_x = Integer.parseInt(st.nextToken());
      int end_y = Integer.parseInt(st.nextToken());

      int n=Integer.parseInt(br.readLine());

      for(int j=0;j<n;j++){
        st=new StringTokenizer(br.readLine());
        int cx=Integer.parseInt(st.nextToken());
        int cy=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        int start_d= (int) Math.sqrt(Math.pow(cx-start_x,2)+Math.pow(cy-start_y,2));
        int end_d= (int) Math.sqrt(Math.pow(cx-end_x,2)+Math.pow(cy-end_y,2));

        if(start_d<r ^ end_d<r)result++;
      }
      System.out.println(result);
    }
  }
}
