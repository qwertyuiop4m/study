package 프로그래머스;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
    static int[] result;
    public static int[] solution(int[][] arr) {
        result = new int[2];
        divied(0,0,arr.length,arr);
        return result;
    }

    private static void divied(int x, int y, int size,int[][] arr) {
        if(isSame(x,y,size,arr)){
            if(arr[x][y]==0) result[0]++;
            else result[1]++;
        }else{
            divied(x,y,size/2,arr);
            divied(x,y+size/2,size/2,arr);
            divied(x+size/2,y,size/2,arr);
            divied(x+size/2,y+size/2,size/2,arr);
        }

    }

    private static boolean isSame(int x, int y, int size, int[][] arr) {
        int value=arr[x][y];
        for(int i=x;i<x+size;i++) {
            for(int j=y;j<y+size;j++) {
                if(value!=arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }
}
