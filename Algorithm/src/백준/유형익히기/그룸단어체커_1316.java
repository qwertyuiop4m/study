package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룸단어체커_1316 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    int n=Integer.parseInt(br.readLine());
    int count=0;
    for (int i = 0; i < n; i++) {
      if (check()){
        count++;
      }
    }
    System.out.println(count);
  }

  public static boolean check() throws IOException {
    boolean[] check = new boolean[26];
    int prev=0;
    String str = br.readLine();
    for (int i = 0; i < str.length(); i++) {
      int now = str.charAt(i) - 'a';
      if (prev != now){
        if (!check[now-'a']){
          check[now-'a']=true;
          prev=now;
        }else return false;
      }
    }
    return true;
  }
}
