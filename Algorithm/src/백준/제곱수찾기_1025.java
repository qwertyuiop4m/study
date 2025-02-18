package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱수찾기_1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] map=new int[n][m];
        int result=-1;
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                for(int di=-n;di<n;di++){
                    for(int dj=-m;dj<m;dj++){
                        if(di==0&&dj==0)continue;

                        int ni=i;
                        int nj=j;
                        int now=0;
                        while (ni>=0&&ni<n&&nj>=0&nj<m){
                            now*=10;
                            now+=map[ni][nj];

                            int sqrt=(int)Math.sqrt(now);
                            if(sqrt*sqrt==now){
                                result=Math.max(result,now);
                            }
                            ni+=di;
                            nj+=dj;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
