package 백준.단계별로_풀기.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일01_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        if(n==1) {
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(2);
            return;
        }
        int a=1;
        int b=2;
        int sum=0;
        for(int i=3;i<=n;i++){
            sum=(a+b)%15746;
            a=b;
            b=sum;
        }
        System.out.println(b);
    }
}
