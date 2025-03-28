//백준 최소 스패닝 트리 자바
//파인드유니온

import java.util.*;
import java.io.*;

public class Main {
    private static int v, e, answer;
    private static class Node implements Comparable<Node> {
        int from, to, value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }

    private static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        nodes = new int[v + 1];
        for (int i = 1; i <= v; i++) nodes[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

           pq.add(new Node(a, b, c));
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node now = pq.poll();
            int to = find(now.to);
            int from = find(now.from);
            if (!isSameParent(to, from)) {
                answer += now.value;
                union(now.to, now.from);
            }
        }
        System.out.println(answer);

    }
    private static int find(int x) {
        if (nodes[x] == x) return x;
        return nodes[x] = find(nodes[x]);
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            nodes[y] = x;
        }
    }
    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        return false;
    }

}
