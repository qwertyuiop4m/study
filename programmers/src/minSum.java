import java.util.Arrays;

public class minSum {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[B.length-i-1];
        }
        return answer;
    }
    public static void main(String[] args)
    {
        minSum test = new minSum();
        int []A = {1,2};
        int []B = {3,4};
        System.out.println(test.solution(A,B));
    }
}
