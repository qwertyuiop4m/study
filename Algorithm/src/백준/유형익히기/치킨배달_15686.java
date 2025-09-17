package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달_15686 {
    static int N,M;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[] pick;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v =  Integer.parseInt(st.nextToken());
                if(v==1)home.add(new int[]{i,j});
                else if(v==2)chicken.add(new int[]{i,j});
            }
        }

        pick=new int[M];
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int start) {
        if(depth==M){
            int sum =0;
            for(int[] h : home){
                int best = Integer.MAX_VALUE;
                for(int j=0;j<M;j++){
                    int[] c= chicken.get(pick[j]);
                    int d = Math.abs(c[0]-h[0])+Math.abs(c[1]-h[1]);
                    best = Math.min(best,d);
                }
                sum += best;
                if(sum>=answer)break;
            }
            answer= Math.min(answer,sum);
            return;
        }
        for(int i=start;i< chicken.size();i++){
            pick[depth] = i;
            dfs(depth+1,i+1);
        }
    }
}
