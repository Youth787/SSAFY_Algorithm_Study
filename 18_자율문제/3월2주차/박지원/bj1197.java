import java.io.*;
import java.util.*;

// boj 최소 스패닝 트리, 크루스칼과 프림 중 크루스칼
class Node implements Comparable<Node> {
    int to;
    int from;
    int weight;
    public Node(int to, int from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
public class Main {

    static int[] nodes;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        nodes = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = i;
        }
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b, w));
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node current = pq.poll();
            int to = find(current.to);
            int from = find(current.from);
            if (!isSameParent(to, from)) {
                answer += current.weight;
                union(current.to, current.from);
            }
        }
        System.out.println(answer);
    }
    static int find(int x) {
        if (nodes[x] == x) return x;
        return nodes[x] = find(nodes[x]);
    }
    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        return false;
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) nodes[y] = x;
    }
}

//https://loosie.tistory.com/330
