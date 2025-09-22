package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 달이차오른다_1194 {
    static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node
    {
        int x;
        int y;
        int key;
        int dist;
        public Node(int x, int y, int key,int dist)
        {
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int start_x = -1, start_y =-1;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '0') {
                    start_x = i;
                    start_y = j;
                    map[i][j] = '.';
                }
            }
        }
        visited = new boolean[n][m][64];
        System.out.println(bfs(start_x, start_y));
    }

    private static int bfs(int sx, int sy) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sx, sy,0,0));
        visited[sx][sy][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x=cur.x;
            int y=cur.y;
            int key=cur.key;
            int dist=cur.dist;

            if(map[x][y] == '1')return dist;

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                int nkey=key;

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                char c=map[nx][ny];
                if(c=='#') continue;

                if('A'<=c && c<='F'){
                    int need = 1 << (c-'A');
                    if((key&need)==0) continue;
                }

                if('a'<=c && c<='f'){
                    nkey = key | (1<<(c-'a'));
                }

                if(visited[nx][ny][nkey])continue;
                visited[nx][ny][nkey] = true;
                q.offer(new Node(nx, ny, nkey, dist+1));
            }
        }
        return -1;
    }
}
