package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드_10816 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb=new StringBuilder();
    int n=Integer.parseInt(br.readLine());
    Map<Integer,Integer> map=new HashMap<>();
    StringTokenizer st=new StringTokenizer(br.readLine());
    for (int i=0;i<n;i++){
      int key=Integer.parseInt(st.nextToken());
      map.put(key,map.getOrDefault(key,0)+1);
    }
    int m=Integer.parseInt(br.readLine());
    st=new StringTokenizer(br.readLine());
    for (int i=0;i<m;i++){
      int key=Integer.parseInt(st.nextToken());
      sb.append(map.getOrDefault(key,0)).append(" ");
    }
    System.out.println(sb.toString());
  }

  private static int lowerBound(int[] arr, int target) {
    int left=0;
    int right=arr.length;
    while(left<right){
      int mid=(left+right)/2;
      if(arr[mid]>=target){
        right=mid;
      }else left=mid+1;
    }
    return left;
  }

  private static int upperBound(int[] arr, int target) {
    int left=0;
    int right=arr.length;
    while(left<right){
      int mid=(left+right)/2;
      if(arr[mid]>target) right=mid;
      else left=mid+1;
    }
    return left;
  }
}
