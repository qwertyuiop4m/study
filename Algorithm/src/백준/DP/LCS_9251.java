package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a= br.readLine();
        String b= br.readLine();
        int alen=a.length();
        int blen=b.length();
        char[] a_char=new char[alen+1];
        for (int i=1;i<=alen;i++){
            a_char[i]=a.charAt(i-1);
        }
        char[] b_char=new char[blen+1];
        for (int i=1;i<=blen;i++){
            b_char[i]=b.charAt(i-1);
        }
        int[][] dp=new int[alen+1][blen+1];
        for (int i=1;i<=alen;i++){
            for (int j=1;j<=blen;j++){
                if(a_char[i]==b_char[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[alen][blen]);
    }
}
