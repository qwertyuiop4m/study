package 단계별로_풀기.조합론;

import java.util.Scanner;

public class 팩토리얼_10872 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if(n<2) return 1;
        return n*factorial(n-1);
    }
}
