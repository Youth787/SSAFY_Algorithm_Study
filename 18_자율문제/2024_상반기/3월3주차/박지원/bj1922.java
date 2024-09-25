import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int to;
    int from;
    int weight;

    public Node(int to, int from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

public class Main {

    static int n, m;
    static ArrayList<Node> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Collections.sort(list);

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            Node n = list.get(i);

            //사이클 발생? 제외
            if (find(n.to) != find(n.from)) {
                ans += n.weight;
                union(n.to, n.from);
            }
        }
        System.out.println(ans);
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

