package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class 어두운굴다리_17266 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[m];
    for(int i=0;i<m;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int result = arr[0];
    for(int i=0;i<m-1;i++){
      int dif = arr[i+1]-arr[i];
      int height = (dif % 2 == 0) ? dif/2 : (dif/2)+1;
      result=Math.max(result, height);
    }
    result = Math.max(result, n-arr[m-1]);
    System.out.println(result);
  }
}
