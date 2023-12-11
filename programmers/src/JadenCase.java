public class JadenCase {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] str=s.toLowerCase().split("");
            boolean flag=true;
            for(int i=0;i<str.length;i++){
                if (flag) answer += str[i].toUpperCase();
                else answer += str[i];
                if (str[i].equals(" "))flag = true;
                else flag = false;
            }
            return answer;
        }
    }
    public static void main(String[] args)
    {
        JadenCase jadenCase = new JadenCase();
        JadenCase.Solution solution = jadenCase.new Solution();
        String result1 = solution.solution("3people unFollowed me");
        String result2 = solution.solution("for the last week");
        System.out.println(result1);
        System.out.println(result2);
    }
}
