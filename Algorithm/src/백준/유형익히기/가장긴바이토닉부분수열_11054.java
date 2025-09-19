package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] lis = new int[n];
        int[] lds = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            lis[i] = 1;
            lds[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (num[i] > num[j]) lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, lis[i] + lds[i]);
        }
        System.out.println(result - 1);
    }
}
