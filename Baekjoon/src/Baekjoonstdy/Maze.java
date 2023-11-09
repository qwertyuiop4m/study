package Baekjoonstdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {
    static boolean visit[][];
    static int maze[][];
    static int Y[]={-1,1,0,0};
    static int X[]={0,0,-1,1};
    static Queue<Node> q=new LinkedList<>();

    static int n_x,n_y;
    static int x,y;
    static int n,m;

    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit=new boolean[n][m];
        maze= new int[n][m];

        for(int i = 0; i < n; i++){
            String s=br.readLine();
            for(int j = 0; j < m; j++){
                char ch=s.charAt(j);
                maze[i][j] = Character.getNumericValue(ch);
            }
        }
        BFS(0,0);
        System.out.println(maze[n-1][m-1]);
    }
    static void BFS(int x, int y) {
        q.offer(new Node(x, y));
        visit[y][x] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                n_x = node.x + X[i];
                n_y = node.y + Y[i];
                if (n_x>=0&&n_x<m&&n_y>=0&&n_y<n && visit[n_y][n_x] == false && maze[n_y][n_x] == 1) {
                    q.offer(new Node(n_x, n_y));
                    visit[n_y][n_x] = true;

                    maze[n_y][n_x] = (maze[node.y][node.x] + 1);
                    if (visit[n - 1][m - 1] == true) {
                        return;
                    }
                }
            }
        }
    }
}

