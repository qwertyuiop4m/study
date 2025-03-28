package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼각형외우기_10101 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a=Integer.parseInt(br.readLine());
    int b=Integer.parseInt(br.readLine());
    int c=Integer.parseInt(br.readLine());
    if (a + b + c != 180) {
      System.out.println("Error");
    } else {
      if(a==60&&b==60&&c==60){
        System.out.println("Equilateral");
      }else if(a==b||a==c||b==c){
        System.out.println("Isosceles");
      }else{
        System.out.println("Scalene");
      }
    }
  }
}
