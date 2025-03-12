package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박스채우기_1493 {

  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int length=Integer.parseInt(st.nextToken());
    int width=Integer.parseInt(st.nextToken());
    int height=Integer.parseInt(st.nextToken());
    int n=Integer.parseInt(br.readLine());
    int[][] cube=new int[2][n];
    for (int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      cube[0][i]=Integer.parseInt(st.nextToken());
      cube[1][i]=Integer.parseInt(st.nextToken());
    }
    long totalVolume=(long)length*width*height;
    long remainingVolume=totalVolume;
    int count=0;
    for (int i=n-1;i>=0;i--){
      int a= (int) Math.pow(2, cube[0][i]);
      long cubeVolume=(long)a*a*a;
      long fitCount = (length / a) * (width / a) * (height / a) - (totalVolume - remainingVolume) / cubeVolume;
      long maxFit=Math.min(fitCount,cube[1][i]);
      count+=maxFit;
      remainingVolume-=maxFit*cubeVolume;
    }
    if (remainingVolume != 0) {
      System.out.println(-1);
    }
    else System.out.println(count);
  }
}
