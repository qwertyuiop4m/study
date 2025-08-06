package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class 먹을것믹힐것_7795 {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for(int i=0;i<t;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] A= new int[n];

      int m = Integer.parseInt(st.nextToken());
      int[] B = new int[m];

      int count =0;
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        A[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(A);

      st=new StringTokenizer(br.readLine());
      for(int k=0;k<m;k++){
        B[k] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(B);

      for(int k=0;k<n;k++){
        count += lowerBound(B, A[k]);
      }
      System.out.println(count);
    }
  }

  private static int lowerBound(int[] arr, int target) {
    int left=0;
    int right=arr.length;
    while(left<right){
      int mid = (left+right)/2;
      if(arr[mid]<target) left = mid+1;
      else right=mid;
    }
    return left;
  }
}
