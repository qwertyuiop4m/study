package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {
    static int X=0;
    static int Y=0;
    static int day=0;
    public int[] solution(String[] maps){
        X=maps.length;
        Y=maps[0].length();

        int[][] map=new int[X][Y];
        for(int i=0;i<X;i++){
            char[] chars=maps[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j]=='X'){
                    map[i][j]=0;
                }else{
                    map[i][j]=chars[j]-'0';
                }
            }
        }

        List<Integer> days=new ArrayList<>();
        boolean[][] visited=new boolean[X][Y];
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++){
                if(!visited[i][j]&&map[i][j]>0){
                    dfs(map,visited,i,j);
                    days.add(day);
                    day=0;
                }
            }
        }

        if(days.isEmpty()){
            return new int[]{-1};
        }

        Collections.sort(days);
        int[] answer=new int[days.size()];
        for(int i=0;i<days.size();i++){
            answer[i]=days.get(i);
        }

        return answer;
    }

    private void dfs(int[][] map, boolean[][] visited, int x, int y) {
        day+=map[x][y];
        visited[x][y]=true;

        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=X||ny>=Y){
                continue;
            }
            if(!visited[nx][ny]&&map[nx][ny]>0){
                dfs(map,visited,nx,ny);
            }
        }
    }

    public static void main(String[] args) {
        무인도여행 sol=new 무인도여행();
        String[] maps={
                "X591X","X1X5X","X231X","1XXX1"
        };
        System.out.println(Arrays.toString(sol.solution(maps)));
        String[] maps2={
                "XXX","XXX","XXX"
        };
        System.out.println(Arrays.toString(sol.solution(maps2)));
    }
}
