package 백준.유형익히기;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_12015 {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    List<Integer> list = new ArrayList<>();
    list.add(arr[0]);
    for (int i = 1; i < n; i++) {
      int val=arr[i];
      if(arr[i]>list.get(list.size()-1)) list.add(val);
      else{
        int left=0;
        int right=list.size()-1;
        int mid=(left+right)/2;
        while(left<right){
          if(val>mid) left=mid+1;
          else right=mid;
        }
        list.set(right,val);
      }
    }
    System.out.println(list.size());
  }
}
