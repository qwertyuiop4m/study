package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 유기농배추_1012 {
    static boolean[][] visited;
    static int[][] map;
    static List<Integer> list;
    static int cnt=1;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list=new ArrayList<>();
            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i=0;i<k;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                map[b][a]=1;
            }
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] == 1&&!visited[x][y]) {
                        dfs(x,y);
                        list.add(cnt);
                        cnt=1;
                    }
                }
            }
            System.out.println(list.size());
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y]=true;
        for (int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=m||ny>=n){
                continue;
            }
            if (map[nx][ny]==1&&!visited[nx][ny]) {
                dfs(nx,ny);
                cnt++;
            }
        }
    }
}
