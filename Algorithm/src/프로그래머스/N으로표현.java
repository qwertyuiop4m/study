package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(solution(5,12));
        System.out.println(solution(2,11));
    }
    public static int solution(int n, int number){
        int answer = 0;

        Set<Integer>[] set = new HashSet[9];

        int num=0;
        for(int i=1;i<=8;i++){
            num = num * 10 + n;
            set[i] = new HashSet<>();
            set[i].add(num);
        }

        if(num==n) return 1;

        for(int i =2; i<=8;i++){
            for(int j=1; j<i;j++){
                for(Integer a : set[j]){
                    for(Integer b : set[i-j]){
                        set[i].add(a-b);
                        set[i].add(a+b);
                        set[i].add(a*b);
                        if(b!=0) set[i].add(a/b);
                        if(a!=0) set[i].add(b/a);
                    }
                }
            }
            if(set[i].contains(number)){
                answer = i;
                return answer;
            }
        }

        answer = -1;

        return answer;
    }
}
