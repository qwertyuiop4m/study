package Baekjoonstdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static int n,m,r;

    public static void bfs(int r){
        int count=0;
        q.add(r);
        check[r]=true;
        while (!q.isEmpty()){
            r=q.poll();
            sb.append(r+" ");
            for(int i=1;i<=n;i++){
                if(arr[r][i]==1&&!check[i]){
                    q.add(i);
                    check[i]=true;
                    count++;
                }
            }
        }
    }

    public static void dfs(int r){
        check[r]=true;
        sb.append(r+" ");
        for(int i=0;i<=n;i++){
            if(arr[r][i]==1&&!check[i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //정점의 개수
        n = Integer.parseInt(st.nextToken());
        //간선의 개수
        m = Integer.parseInt(st.nextToken());
        //처음 노드
        r =Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        check=new boolean[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer str=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(str.nextToken());
            int b=Integer.parseInt(str.nextToken());
            arr[a][b]=arr[b][a]=1;
        }
        dfs(r);
        sb.append("\n");
        check=new boolean[n+1];

        //bfs(r);

        System.out.println(sb);

    }
}
