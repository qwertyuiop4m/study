package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
    static class Edge{
        int to, w;
        public Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }

    static boolean[] visited;
    static int max = 0;
    static int node;
    static ArrayList<Edge>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];
        for(int i=1;i<=V;i++) adj[i]=new ArrayList();

        for(int i=0;i<V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true){
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)break;
                int w = Integer.parseInt(st.nextToken());

                adj[from].add(new Edge(to,w));
            }
        }

        visited = new boolean[V+1];
        dfs(1,0);

        visited=new boolean[V+1];
        dfs(node,0);

        System.out.println(max);

    }

    private static void dfs(int v,int dist) {
        visited[v] = true;
        if(dist > max){
            max = dist;
            node = v;
        }
        for (Edge e : adj[v]) {
            if(!visited[e.to]){
                dfs(e.to,dist+e.w);
            }
        }
    }
}
