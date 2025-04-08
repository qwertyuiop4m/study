package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기_11497 {
  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n=Integer.parseInt(br.readLine());
      StringTokenizer st=new StringTokenizer(br.readLine());
      int[] num=new int[n];
      for (int j = 0; j < n; j++) {
        num[j]=Integer.parseInt(st.nextToken());
      }
      Arrays.sort(num);
      int[] num2=new int[n];
      int left=0;
      int right=num.length-1;
      for(int j=0;j<n;j++){
        if(j%2==0) num2[left++]=num[j];
        else num2[right--]=num[j];
      }
      int result=0;
      for(int j=1;j<n;j++){
        result=Math.max(result,Math.abs(num2[j]-num2[j-1]));
      }
      System.out.println(result);
    }
  }
}
