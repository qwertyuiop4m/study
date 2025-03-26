package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String line=br.readLine();
      Stack<Character> stack=new Stack<>();
      for (int j = 0; j < line.length(); j++) {
        char ch=line.charAt(j);
        if(ch=='('){
          stack.push(ch);
        }else if(ch==')'){
          if(stack.isEmpty()){
            stack.push(ch);
            break;
          }else stack.pop();
        }
      }
      if(stack.isEmpty()){
        System.out.println("YES");
      }else{
        System.out.println("NO");
      }
    }
  }
}
