package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 선긋기_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(o1,o2)->{
            if(o1[0]!=o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        int start =  arr[0][0];
        int end = arr[0][1];

        int result= 0;

        for(int i=1;i<n;i++){
            if(arr[i][0]<=end){
                end=Math.max(end,arr[i][1]);
            }else{
                result+=end-start;
                start = arr[i][0];
                end = arr[i][1];
            }

        }
        result+=end-start;
        System.out.println(result);
    }
}
