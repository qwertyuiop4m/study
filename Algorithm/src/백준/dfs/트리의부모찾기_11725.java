package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
   static List<Integer>[] graph;
   static boolean[] visited;
   static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        visited=new boolean[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            graph[left].add(right);
            graph[right].add(left);
        }
        printGraph(n);
        dfs(1);

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }
    private static void printGraph(int n) {
        System.out.println("그래프 출력:");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : graph[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    private static void dfs(int i) {
        visited[i]=true;
        for(int child :graph[i]){
            if(!visited[child]){
                parent[child]=i;
                dfs(child);
            }
        }
    }

}
