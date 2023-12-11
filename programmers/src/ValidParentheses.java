import java.util.Stack;

public class ValidParentheses {
    class Solution {
        boolean solution(String s) {
            boolean answer = false;

            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(') stack.push('(');
                else if(s.charAt(i)==')'){
                    if(stack.isEmpty()){
                        answer=false;
                        return answer;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty())answer=true;
            return answer;
        }
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        Solution solution = validParentheses.new Solution();

        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("(())()"));
        System.out.println(solution.solution(")()("));
        System.out.println(solution.solution("(()("));
    }
}
