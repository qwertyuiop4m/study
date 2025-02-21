package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Node {
  int end;
  int weight;

  public Node(int end, int weight) {
    this.end = end;
    this.weight = weight;
  }
}
public class 최단경로_1753 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e= Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());
    int[] result=new int[v+1];
    List<Node>[] graph=new ArrayList[v+1];
    for(int i=1;i<=v;i++){
      graph[i]=new ArrayList<>();
      result[i]=Integer.MAX_VALUE;
    }
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int U = Integer.parseInt(st.nextToken());
      int V=Integer.parseInt(st.nextToken());
      int W=Integer.parseInt(st.nextToken());
      graph[U].add(new Node(V,W));
    }
    PriorityQueue<Node> pq=new PriorityQueue<>(((o1, o2) -> o1.weight-o2.weight));
    result[k]=0;
    pq.add(new Node(k,0));
    while(!pq.isEmpty()){
      Node now=pq.poll();
      if (now.weight>result[now.end]){continue;}
      for (int i=0;i<graph[now.end].size();i++) {
        Node next = graph[now.end].get(i);
        if (now.weight + next.weight < result[next.end]) {
          result[next.end] = now.weight + next.weight;
          pq.add(new Node(next.end, now.weight + next.weight));
        }
      }
    }
    for (int i=1;i<=v;i++){
      if (result[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(result[i]);
      }
    }
  }
}
