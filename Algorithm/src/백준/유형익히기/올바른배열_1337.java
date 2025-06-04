package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 올바른배열_1337 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int result=0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int min=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      int need=0;
      int start=arr[i];
      for(int j=0;j<5;j++){
        int current=start+j;
        if(Arrays.binarySearch(arr,current)<0){
          need++;
        }
      }
      min=Math.min(min,need);
    }
    System.out.println(min);
  }
}
