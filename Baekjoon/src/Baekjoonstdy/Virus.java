package Baekjoonstdy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
    static boolean[] check;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static int n,m;

    public static int bfs(int r){
        int count=0;
        q.offer(r);
        check[r]=true;
        while (!q.isEmpty()){
            int temp=q.poll();
            for(int i=1;i<=n;i++){
                if(arr[temp][i]==1&&!check[i]){
                    q.offer(i);
                    check[i]=true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //컴퓨터의 수
        n = sc.nextInt();
        //연결되어 있는 컴퓨터의 수
        m = sc.nextInt();

        arr=new int[n+1][n+1];
        check=new boolean[n+1];

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=arr[b][a]=1;
        }

        System.out.println(bfs(1));
        sc.close();

    }
}

