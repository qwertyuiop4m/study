package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정도시거리찾기_18325 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(bf.readLine());
    int n=Integer.parseInt(st.nextToken());
    int m=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());
    int x=Integer.parseInt(st.nextToken());
    List<List<Integer>> graph=new ArrayList<>();
    for (int i = 0; i < n+1; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st=new StringTokenizer(bf.readLine());
      int u=Integer.parseInt(st.nextToken());
      int v=Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
    }
    int[] num=new int[n+1];
    Arrays.fill(num,-1);
    num[x]=0;
    Queue<Integer> queue=new LinkedList<>();
    queue.add(x);
    while (!queue.isEmpty()) {
      int current= queue.poll();
      for (int next : graph.get(current)) {
        if (num[next]==-1) {
          num[next]=num[current]+1;
          queue.add(next);
        }
      }
    }
    boolean flag=false;
    for(int i=1;i<=n;i++){
      if(num[i]==k){
        System.out.println(i);
        flag=true;
      }
    }
    if(!flag){
      System.out.println(-1);
    }
  }
}
