//백준 트리순회 자바
//클래스구현 + 재귀

import java.io.*;
import java.util.*;

public class Main{
    private static class Node {
        char value;
        Node left;
        Node right;
        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private static int n;
    private static Node[] tree;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            // Java에서 char 데이터 타입은 내부적으로 ASCII 코드를 사용
            if (tree[parent - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parent - 'A'] = new Node(parent);
            }
            if (left != '.') { // 왼쪽자식이 존재할경우
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') { // 오른쪽자식이 존재할경우
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }

        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }
    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}

