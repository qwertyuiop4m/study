package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_4307 {
  static int min=Integer.MAX_VALUE;
  static int max=Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    for(int i=0;i<t;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      int length=Integer.parseInt(st.nextToken());
      int n=Integer.parseInt(st.nextToken());

      int min=0;
      int max=0;

      for(int j=0;j<n;j++){
        int position=Integer.parseInt(br.readLine());
        int timeToLeft=position;
        int timeToRight=length-position;

        min=Math.max(min,Math.min(timeToLeft,timeToRight));
        max=Math.max(max,Math.max(timeToLeft,timeToRight));

        System.out.println(min+" "+max);
      }
    }
  }
}
