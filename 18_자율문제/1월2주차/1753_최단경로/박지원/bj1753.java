import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
    int next;
    int cost;
    Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
public class Main {

    static int v, e, k;
    static ArrayList<ArrayList<Node>> graph;
    static int[] route;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        route = new int[v + 1];
        Arrays.fill(route, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, w));

        }

        route[k] = 0;
        solve(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (route[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(route[i]).append("\n");
        }
        System.out.println(sb);

    }
    static void solve(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Node n: graph.get(current.next)) {
                int nextCost = current.cost + n.cost;
                if (route[n.next] <= nextCost) continue;
                route[n.next] = nextCost;
                pq.add(new Node(n.next, nextCost));

            }

        }
    }
}
