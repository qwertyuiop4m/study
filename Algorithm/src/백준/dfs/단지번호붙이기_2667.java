package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667 {
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int danji,n;
    static int[][] map;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        visited=new boolean[n][n];
        danji=1;
        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j)-'0';
            }
        }
        list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1&& !visited[i][j]){
                    dfs(i,j);
                    list.add(danji);
                    danji=1;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y]=true;
        for (int k = 0; k < 4; k++) {
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx<0||ny<0||nx>=n||ny>=n){
                continue;
            }
            if(map[nx][ny]==1 && !visited[nx][ny]){
                danji++;
                dfs(nx,ny);
            }
        }
    }
}
