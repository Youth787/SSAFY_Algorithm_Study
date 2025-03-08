//백준 문제집 자바
//위상정렬

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] degree;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        degree = new int[n + 1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            degree[b]++;
        }
        topologicalSort();
        System.out.println(sb.toString());
    }
    private static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) pq.add(i);
        }
        
        while (!pq.isEmpty()) {
            int now = pq.poll();
            for (int next: list.get(now)) {
                degree[next]--;

                if (degree[next] == 0) pq.add(next);
            }
            sb.append(now).append(" ");
        }
    }

}
