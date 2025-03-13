//백준 백도어 자바
//다익스트라, long!!!!

import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int next;
        long time;

        public Node (int next, long time) {
            this.next = next;
            this.time = time;
        }
    }
    private static int n, m;
    private static boolean[] visited, sight;
    private static final long INF = Long.MAX_VALUE;
    private static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sight = new boolean[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String temp = st.nextToken();
            if (temp.equals("1")) sight[i] = true;
        }
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());

        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, t));
            list.get(b).add(new Node(a, t));
        }
        long answer = dijkstra();
        System.out.println(answer);

    }
    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.time, o2.time));
        long[] dist = new long[n];
        for (int i = 0; i < n; i++) dist[i] = INF;
        dist[0] = 0;
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.next] = true;
            if (now.next == n - 1) {
                return now.time;
            }
            if (dist[now.next] < now.time) continue;

            for (Node go: list.get(now.next)) {
                if (sight[go.next] && go.next != n - 1) continue;
                if (dist[go.next] > dist[now.next] + go.time) {
                    dist[go.next] = dist[now.next] + go.time;
                    pq.add(new Node(go.next, now.time + go.time));
                }
            }
        }
        return -1;
    }


}

