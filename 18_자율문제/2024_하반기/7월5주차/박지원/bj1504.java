//백준 특정한 최단거리 자바
//다익스트라! 인접리스트 만든거, class Node 정의한거까지 너무 좋았는데 dist배열을 만들어서 거리를 저장하는 것에 어려움을 느꼈다. 다시한번 풀어보기!

import java.io.*;
import java.util.*;

public class Main{
    private static class Node implements Comparable<Node> {
        int end, dist;
        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }
    private static int n, e, v1, v2;
    private static ArrayList<ArrayList<Node>> list;
    private static int[] dist;
    private static boolean[] visited;
    private static int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);

        int answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);

        System.out.println(answer);

    }
    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;
                for (Node node: list.get(now.end)) {
                    if (!visited[node.end] && dist[node.end] > dist[now.end] + node.dist) {
                        dist[node.end] = dist[now.end] + node.dist;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
