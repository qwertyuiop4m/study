package 프로그래머스;

import java.util.Arrays;


public class 섬연걸하기 {
    private int[] parent;
    public int find(int a) {
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }
    public void union(int a, int b) {
        a=find(a);
        b=find(b);
        if(a!=b) parent[b]=a;
    }
    public int solution(int n, int[][] costs) {
        int answer=0;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Arrays.sort(costs,(o1,o2)->(o1[2]-o2[2]));
        for(int i=0;i<costs.length;i++){
            if(find(costs[i][0])!=find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                answer+=costs[i][2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        섬연걸하기 solver = new 섬연걸하기();
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };
        int result = solver.solution(4, costs);
        System.out.println("최소 비용: " + result);
    }
}
