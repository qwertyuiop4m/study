package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_1158 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());

    Queue<Integer> queue=new LinkedList<>();
    for(int i=1;i<=n;i++) queue.add(i);

    List<Integer> list=new ArrayList<>();
    while (!queue.isEmpty()){
      for (int i=1;i<k;i++){
        queue.add(queue.poll());
      }
      list.add(queue.poll());
    }
    System.out.print("<");
    for (int i=0;i<list.size();i++){
      System.out.print(list.get(i));
      if(i!=list.size()-1) System.out.print(", ");
    }
    System.out.println(">");
  }
}
