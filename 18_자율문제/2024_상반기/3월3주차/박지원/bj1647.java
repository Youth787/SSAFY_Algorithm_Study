import java.io.*;
import java.util.*;

//백준 도시 분할 계획 크루스칼 알고리즘(최소스패닝트리)
class Node implements Comparable<Node> {
    int from;
    int to;
    int weight;
    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

public class Main {
    static int n,m;
    static ArrayList<Node> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, w));
        }
        Collections.sort(list);
        int ans = 0;
        int bigCost = 0;
        for (int i = 0; i < list.size(); i++) {
            Node current = list.get(i);

            if (find(current.from) != find(current.to)) {
                ans += current.weight;
                union(current.from, current.to);

                bigCost = current.weight;
            }
        }
        System.out.println(ans - bigCost);



    }
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}

