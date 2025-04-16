//백준 효율적인 해킹 자바
//dfs + 메모이제이션
//bfs로 풀면 시간초과

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        count = new int[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 역방향 그래프: b → a (b를 해킹하면 a도 해킹 가능)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            count[i] = dfs(i);
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int dfs(int x) {
        visited[x] = true;
        int res = 1; // 자기 자신 포함

        for (int next : graph[x]) {
            if (!visited[next]) {
                res += dfs(next);
            }
        }

        return res;
    }
}
