package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 젤다_4485 {

  static int[] dx={-1,1,0,0};
  static int[] dy={0,0,-1,1};

  static class Node implements Comparable<Node>{
    int x,y,cost;
    Node(int x,int y,int cost){
      this.x=x;
      this.y=y;
      this.cost=cost;
    }
    public int compareTo(Node o) {
      return this.cost-o.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t=1;
    while (true){
      int n=Integer.parseInt(br.readLine());
      if(n==0)break;

      int[][] map=new int[n][n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j]=Integer.parseInt(st.nextToken());
        }
      }

      int[][] dist=new int[n][n];
      for(int[] row:dist)Arrays.fill(row,Integer.MAX_VALUE);
      dist[0][0]=map[0][0];

      PriorityQueue<Node> pq=new PriorityQueue<>();
      pq.offer(new Node(0,0,map[0][0]));
      while(!pq.isEmpty()){
        Node cur=pq.poll();
        for(int d=0;d<4;d++){
          int nx=cur.x+dx[d];
          int ny=cur.y+dy[d];
          if(nx<0||ny<0||nx>=n||ny>=n)continue;

          int nextCost=cur.cost+map[nx][ny];

          if(nextCost<dist[nx][ny]){
            dist[nx][ny]=nextCost;
            pq.offer(new Node(nx,ny,nextCost));
          }
        }
      }
      System.out.println("Problem "+t++ + ": "+dist[n-1][n-1]);
    }

  }
}
