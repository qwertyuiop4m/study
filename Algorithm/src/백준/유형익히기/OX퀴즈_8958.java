package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class OX퀴즈_8958 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for(int i=0;i<n;i++){
      String s = br.readLine();
      int result=0;
      int score=0;
      for(int j=0;j<s.length();j++){
        char c=s.charAt(j);
        if(c=='O'){
          score++;
          result+=score;
        }else score=0;
      }
      System.out.println(result);
    }
  }
}
