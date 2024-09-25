//백준 트리의 지름 자바
//지름에 속한 두 점이 아닌 아무 점에서 시작해서 가장 먼 점이 지름에 속한 점이란 것을 토대로 아무점이나 시작해서 가장 먼 점을 찾고, 거기서부터 다른 지름의 점을 구해서 거리를 구하는 방식 https://velog.io/@mendel/%EB%B0%B1%EC%A4%80-1967-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84-java
// dfs로도 풀이 가능!

import java.io.*;
import java.util.*;

public class Main{
    private static class Node {
        int end, cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    private static int n;
    private static ArrayList<Node>[] tree;
    private static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            tree[start].add(new Node(end, value));
            tree[end].add(new Node(start, value));
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> answer = dijkstra(1);
        int ans = dijkstra(answer.get(1)).get(0);
        System.out.println(ans);
    }
    private static List<Integer> dijkstra(int s) {
        int max = 0;
        int nodeNum = s;
        int[] table = new int[n + 1];
        Arrays.fill(table, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                return o1.cost - o2.cost;
        });
        pq.add(new Node(s, 0));
        table[s] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node nextN: tree[cur.end]) {
                if (table[nextN.end] > table[cur.end] + nextN.cost) {
                    table[nextN.end] = table[cur.end] + nextN.cost;
                    pq.add(new Node(nextN.end, table[nextN.end]));
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (i == s) continue;
            if (max < table[i]) {
                max = table[i];
                nodeNum = i;
            }
        }
        return List.of(max, nodeNum);
    }
}
