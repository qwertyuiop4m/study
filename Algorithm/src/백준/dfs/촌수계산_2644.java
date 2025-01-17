package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int result=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());

        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        printGraph(n);

        visited=new boolean[n+1];

        dfs(start,end,0);

        System.out.println(result);
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

    private static void dfs(int current, int target, int count) {
        if(target==current){
            result=count;
            return;
        }
        visited[current]=true;
        for(int i=0;i<graph[current].size();i++){
            if(!visited[graph[current].get(i)]){
                dfs(graph[current].get(i),target,count+1);
            }
        }
    }
}
