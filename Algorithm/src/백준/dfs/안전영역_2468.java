package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int maxHeight=0;
    static int max=0;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height=Integer.parseInt(st.nextToken());
                map[i][j]=height;
                maxHeight=Math.max(maxHeight,height);
            }
        }
        for(int i=0;i<maxHeight;i++){
            int count=0;
            visited=new boolean[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if (!visited[j][k]&&map[j][k]>i){
                        count+=dfs(i,j,k);
                    }
                }
            }
            max=Math.max(count,max);
        }
        System.out.println(max);
    }

    private static int dfs(int height,int x, int y) {
        visited[x][y]=true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0||ny<0||nx>=N||ny>=N)continue;
            if(map[nx][ny]>height&&!visited[nx][ny])dfs(height,nx,ny);
        }
        return 1;
    }
}
