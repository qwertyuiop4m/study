package Baekjoonstdy;

import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();;
        int[] array = new int[n];
        int[] counting = new int[10];
        int[] result = new int[n];

        for(int i = 0; i < array.length; i++) {
            array[i]  = sc.nextInt();
        }


        // Counting Sort
        // 과정 1
        for(int i = 0; i < array.length; i++) {
            // array 의 value 값을 index 로 하는 counting 배열 값 1 증가
            counting[array[i]]++;
        }

        // 과정 2
        for(int i = 1; i < counting.length; i++) {
            // 누적 합 해주기
            counting[i] += counting[i - 1];
        }

        // 과정 3
        for(int i = array.length - 1; i >= 0; i--) {

            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }
        for(int i = 0; i < result.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.println(result[i]);
        }
        System.out.println();
    }
}
