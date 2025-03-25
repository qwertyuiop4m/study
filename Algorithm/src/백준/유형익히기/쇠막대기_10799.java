package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기_10799 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    Stack<Character> stack = new Stack<>();
    int count=0;
    stack.push(line.charAt(0));
    for (int i = 1; i < line.length(); i++) {
      char c = line.charAt(i);
      if (c == '(') {
        stack.push(c);
      }else if (c == ')') {
        if (line.charAt(i-1) == ')') {
          stack.pop();
          count++;
        }else{
          stack.pop();
          count+=stack.size();
        }
      }
    }
    System.out.println(count);
  }
}
