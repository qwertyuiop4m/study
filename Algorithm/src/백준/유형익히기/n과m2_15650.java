package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n과m2_15650 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0,0);
    }

    private static void dfs(int depth, int start) {
        if(depth == m){
            for(int i = 0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i<n; i++){
            arr[depth] = i+1;
            dfs(depth+1, i+1);
        }
    }
}
