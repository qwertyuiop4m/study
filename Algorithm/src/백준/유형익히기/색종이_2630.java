package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이_2630 {
  static int[][] arr;
  static int zero = 0;
  static int one = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(line[j]);
      }
    }

    divide(0, 0, n);
    System.out.println(zero);
    System.out.println(one);
  }

  private static void divide(int x, int y, int size) {
    if (isSame(x, y, size)) {
      if (arr[x][y] == 0) zero++;
      else one++;
      return;
    }

    int newSize = size / 2;
    divide(x, y, newSize); // 좌상
    divide(x, y + newSize, newSize); // 우상
    divide(x + newSize, y, newSize); // 좌하
    divide(x + newSize, y + newSize, newSize); // 우하
  }

  private static boolean isSame(int x, int y, int size) {
    int val = arr[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (arr[i][j] != val) return false;
      }
    }
    return true;
  }
}
