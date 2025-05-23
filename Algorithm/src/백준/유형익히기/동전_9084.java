package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_9084 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    for(int i=0;i<t;i++){
      int n=Integer.parseInt(br.readLine());
      int[] coin=new int[n];
      StringTokenizer st=new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        coin[j]=Integer.parseInt(st.nextToken());
      }
      int m=Integer.parseInt(br.readLine());
      int[] dp=new int[m+1];
      dp[0]=1;
      for(int k=0;k<n;k++){
        for(int l=coin[k];l<=m;l++){
          dp[l]+=dp[l-coin[k]];
        }
      }
      System.out.println(dp[m]);
    }
  }
}
