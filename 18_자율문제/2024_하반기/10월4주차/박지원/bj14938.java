//백준 서강그라운드 자바
//다익스트라 + 조건설정

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }
    private static int n, m, r;
    private static int[] item;
    private static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    private static boolean[] visited;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b, c));
            map.get(b).add(new Node(a, c));
        }
        int answer = 0;
        for (int i= 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }
    private static int dijkstra(int now) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(now, 0));
        dist[now] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!visited[node.num]) {
                visited[node.num] = true;
                for (Node no: map.get(node.num)) {
                    if (!visited[no.num] && dist[no.num] > dist[node.num] + no.dist) {
                        dist[no.num] = dist[node.num] + no.dist;
                        pq.add(new Node(no.num, dist[no.num]));
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) res += item[i];
        }
        return res;
    }
}
