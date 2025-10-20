package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석쇼핑 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        int kind = new HashSet<>(Arrays.asList(gems)).size();

        Map<String , Integer> map = new HashMap<>();

        int length = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if(map.size() == kind && length>(end - start)){
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        System.out.println(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}));
        System.out.println(solution(new String[]{"XYZ", "XYZ", "XYZ"}));
        System.out.println(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
    }
}
