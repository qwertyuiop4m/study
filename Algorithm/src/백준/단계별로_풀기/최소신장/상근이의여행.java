package 백준.단계별로_풀기.최소신장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근이의여행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine()," ");
            }
            System.out.println(N-1);
        }
    }
}
