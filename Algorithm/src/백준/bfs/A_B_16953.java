package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_B_16953 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int cnt=1;
    while (a!=b){
      if(b<a){
        System.out.println(-1);
        System.exit(0);
      }
      if(b%10==1){
        b/=10;
      }else if(b%2==0){
        b/=2;
      }else{
        System.out.println(-1);
        System.exit(0);
      }
      cnt++;
    }
    System.out.println(cnt);
  }
}
