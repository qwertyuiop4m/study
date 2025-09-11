package 프로그래머스;

import java.util.Arrays;

public class 서버증설횟수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3,5));
        System.out.println(solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},5,1));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},1,1));
    }
    public static int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] diff = new int[n+k+1];
        int active =0;
        int answer = 0;

        for(int i=0;i<n;i++){
            active += diff[i];
            int required = players[i]/m;
            int need = Math.max(0,required-active);
            if(need>0){
                answer+=need;
                active += need;
                diff[i] += need;
                diff[i+k] -= need;
            }
        }
        return answer;
    }
}
