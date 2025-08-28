package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리_1991 {
    static class Node{
        char value;
        Node left, right;

        Node(char  value){
            this.value=value;
        }
    }

    static Node[] nodes = new Node[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) nodes[i]=null;

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if(nodes[p-'A'] == null) nodes[p-'A']=new Node(p);
            Node parent = nodes[p-'A'];

            if(l!='.'){
                if (nodes[l-'A'] ==null ) nodes[l-'A']=new Node(l);
                parent.left=nodes[l-'A'];
            }

            if (r!='.'){
                if (nodes[r-'A'] ==null ) nodes[r-'A']=new Node(r);
                parent.right=nodes[r-'A'];
            }
        }
        Node root = nodes[0];

        preorder(root);
        sb.append('\n');
        inorder(root);
        sb.append('\n');
        postorder(root);
        sb.append('\n');

        System.out.println(sb.toString());
    }

    private static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        sb.append(root.value);
    }

    private static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        sb.append(root.value);
        inorder(root.right);
    }

    private static void preorder(Node root) {
        if (root == null) return;
        sb.append(root.value);
        preorder(root.left);
        preorder(root.right);
    }
}
