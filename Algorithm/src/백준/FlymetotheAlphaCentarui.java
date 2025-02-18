package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentarui {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance=y-x;
            int sqrtDistance=(int)Math.sqrt(distance);
            if(distance==sqrtDistance*sqrtDistance){
                System.out.println(sqrtDistance*2-1);
            }else if(distance<=sqrtDistance*sqrtDistance+sqrtDistance){
                System.out.println(sqrtDistance*2);
            }else {
                System.out.println(sqrtDistance*2+1);
            }
        }
    }
}
