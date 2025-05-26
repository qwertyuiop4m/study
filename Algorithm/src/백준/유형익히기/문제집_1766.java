package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집_1766 {

  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    List<List<Integer>> graph=new ArrayList<>();
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }
    int[] indegree=new int[n+1];
    for (int i=0;i<m;i++){
      st=new StringTokenizer(br.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      indegree[b]+=1;
    }
    ArrayList<Integer> result=new ArrayList<>();
    PriorityQueue<Integer> q=new PriorityQueue<>();
    for(int i=1;i<=n;i++){
      if(indegree[i]==0){
        q.offer(i);
      }
    }
    while(!q.isEmpty()){
      int now=q.poll();
      result.add(now);
      for (int i=0;i<graph.get(now).size();i++){
        indegree[graph.get(now).get(i)]-=1;
        if(indegree[graph.get(now).get(i)]==0){
          q.offer(graph.get(now).get(i));
        }
      }
    }
    for(int i=0;i<result.size();i++){
      System.out.print(result.get(i)+" ");
    }
  }
}
