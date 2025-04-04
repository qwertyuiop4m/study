package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백설공주_3040 {
  static int[] num = new int[10];
  static int[] selected = new int[7];
  static boolean found = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 9; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    findCombination(0, 0);
  }

  private static void findCombination(int index, int count) {
    if (found) return;

    if (count == 7) {
      int sum = 0;
      for (int i = 0; i < 7; i++) {
        sum += selected[i];
      }
      if (sum == 100) {
        for (int i = 0; i < 7; i++) {
          System.out.println(selected[i]);
        }
        found = true;
      }
      return;
    }

    if (index >= 9) return;

    selected[count] = num[index];
    findCombination(index + 1, count + 1);
    findCombination(index + 1, count);
  }
}
