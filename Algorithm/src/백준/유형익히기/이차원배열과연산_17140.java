package 백준.유형익히기;

import java.io.*;
import java.util.*;

public class 이차원배열과연산_17140 {
  static int[][] A = new int[101][101];
  static int r,c,k;
  static int rowLen =3, colLen=3;
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for(int i=0;i<3;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<3;j++){
        A[i][j]=Integer.parseInt(st.nextToken());
        }
      }

    int time=0;
    while(time<=100){
      if(A[r-1][c-1]==k){
        System.out.println(time);
        return;
      }
      if(rowLen>=colLen){
        R_operation();
      }else{
        C_operation();
      }
      time++;
    }
    System.out.println(-1);
  }

  private static void C_operation() {
    int maxRow=0;
    for(int j=0;j<colLen;j++){
      Map<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<rowLen;i++){
        int val=A[i][j];
        if(val==0)continue;
        map.put(val,map.getOrDefault(val,0)+1);
      }

      List<int[]> list = new ArrayList<>();
      for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        list.add(new int[]{entry.getKey(),entry.getValue()});
      }

      list.sort((a,b)->{
        if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
      });

      int index=0;
      for(int[] pair : list){
        if(index>=100) break;
        A[index++][j]=pair[0];
        A[index++][j]=pair[1];
      }

      for(int i = index;i<100;i++){
        A[i][j]=0;
      }
      maxRow=Math.max(maxRow,index);
    }
    rowLen=maxRow;
  }

  private static void R_operation() {
    int maxCol=0;
    for(int i=0;i<rowLen;i++){
      Map<Integer,Integer> map = new HashMap<>();
      for(int j=0;j<colLen;j++){
        int val=A[i][j];
        if(val==0) continue;
        map.put(val,map.getOrDefault(val,0)+1);
      }

      List<int[]> list = new ArrayList<>();
      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        list.add(new int[]{entry.getKey(),entry.getValue()});
      }

      list.sort((a,b)->{
        if(a[1] == b[1]) return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
      });

      int index=0;
      for(int[] pair : list){
        if(index >= 100) break;
        A[i][index++] = pair[0];
        A[i][index++] = pair[1];
      }

      for(int j= index;j<100;j++){
        A[i][j]=0;
      }
      maxCol = Math.max(maxCol,index);
    }
    colLen=maxCol;
  }
}
