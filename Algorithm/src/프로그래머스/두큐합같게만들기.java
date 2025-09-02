package 프로그래머스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long total = 0;
        long q1Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            total += queue1[i]+queue2[i];
            q1Sum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if(total % 2 !=0) return -1;

        long target = total / 2;
        while(true){
            if(answer>(queue1.length+queue2.length)*2)return -1;
            if(q1Sum == target)break;
            else if(q1Sum > target){
                q1Sum-=q1.peek();
                q2.add(q1.poll());
            }else{
                q1Sum+=q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }

        return answer;
    }

}
