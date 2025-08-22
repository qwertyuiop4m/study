package 프로그래머스;

import java.util.*;

public class 압축 {
    public static int[] solution(String msg) {
        List<Integer> list=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();

        int code=1;
        for(char ch='A'; ch<='Z'; ch++) {
            map.put(String.valueOf(ch), code++);
        }

        int i=0;
        while(i<msg.length()){
            String str = "";
            while(i<msg.length()){
                char c = msg.charAt(i);
                if (!map.containsKey(str + c)) break;
                str += c;
                i++;
            }
            list.add(map.get(str));

            if(i<msg.length()){
                map.put(str+msg.charAt(i),map.size()+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
