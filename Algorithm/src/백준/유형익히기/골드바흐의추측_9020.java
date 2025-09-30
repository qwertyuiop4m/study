package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int a = n / 2;
            int b = n / 2;

            while (true) {
                if (isPrime(a) && isPrime(b)) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
    }

    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for ( int i = 2; i * i <= a; i++){
            if(a%i==0) return false;
        }
        return true;
    }
}
