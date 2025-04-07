package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합_1789 {
  public static void main(String[] args) throws IOException {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   long n=Long.parseLong(br.readLine());
   long sum=0;
   int i=1;
   while(i+sum<=n){
     sum+=i++;
   }
    System.out.println(i-1);
  }
}
