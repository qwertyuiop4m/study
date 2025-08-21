package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int one=0;
        int zero=0;
        int i=0;
        if(s.charAt(0)=='0') zero++;
        else one++;
        while(i<s.length()-1){
            char  c=s.charAt(i);
            char next_c=s.charAt(i+1);
            if(c=='0'){
                if(next_c=='1'){
                    one++;
                }
            }else if(c=='1'){
                if(next_c=='0'){
                    zero++;
                }
            }
            i++;
        }

        System.out.println(Math.min(one,zero));
    }
}
