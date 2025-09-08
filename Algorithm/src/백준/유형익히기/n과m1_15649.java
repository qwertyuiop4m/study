package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n과m1_15649 {
    static int n,m;
    static boolean[] visited;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        visited=new boolean[n];
        num=new int[m];

        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth==m){
            for(int j=0;j<m;j++){
                System.out.print(num[j]+" ");
            }
            System.out.println();
            return;
        }
        for(int j=0;j<n;j++){
            if(!visited[j]){
                visited[j]=true;
                num[depth]=j+1;
                dfs(depth+1);
                visited[j]=false;
            }
        }

    }
}
