package 프로그래머스;

import java.util.*;

public class 여행경로 {
    static ArrayList<String> result;
    static boolean[]visited;
    public static class Solution {
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            result=new ArrayList<>();
            visited=new boolean[tickets.length];
            dfs("ICN","ICN",tickets,0);
            Collections.sort(result);
            answer=result.get(0).split(" ");
            return answer;
        }

        private void dfs(String start,String route,String[][] tickets, int cnt) {
            if(cnt==tickets.length){
                result.add(route);
                return;
            }
            for(int i=0;i<tickets.length;i++){
                if(!visited[i]&&start.equals(tickets[i][0])){
                    visited[i]=true;
                    dfs(tickets[i][1],route+" "+tickets[i][1],tickets,cnt+1);
                    visited[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] tickets1 = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        System.out.println(Arrays.toString(sol.solution(tickets1)));

        String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"},
        };
        System.out.println(Arrays.toString(sol.solution(tickets2)));
    }
}
