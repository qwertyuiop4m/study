package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class 제로만들기_7490 {
  static int N;
  static List<String> results = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      results.clear();

      dfs(1, "1");  // 시작 숫자와 수식 초기값

      Collections.sort(results);
      for (String res : results) {
        System.out.println(res);
      }
      System.out.println();  // 테스트케이스 사이 빈 줄
    }
  }

  // DFS로 수식 생성
  private static void dfs(int num, String expr) {
    if (num == N) {
      if (evaluate(expr.replaceAll(" ", "")) == 0) {
        results.add(expr);
      }
      return;
    }

    int next = num + 1;
    dfs(next, expr + " " + next);  // 숫자 이어붙이기
    dfs(next, expr + "+" + next);  // 덧셈
    dfs(next, expr + "-" + next);  // 뺄셈
  }

  // 수식 문자열을 계산하는 메서드
  private static int evaluate(String expr) {
    int sum = 0;
    int num = 0;
    char op = '+';

    for (int i = 0; i < expr.length(); i++) {
      char c = expr.charAt(i);

      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      }

      if (!Character.isDigit(c) || i == expr.length() - 1) {
        if (op == '+') {
          sum += num;
        } else if (op == '-') {
          sum -= num;
        }
        op = c;
        num = 0;
      }
    }

    return sum;
  }
}