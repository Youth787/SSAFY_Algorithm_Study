import java.io.*;
import java.util.*;

public class bj13913 {
    public static int n, k;
    public static int[] time, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        time = new int[100001];
        parent = new int[100001];
        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;

        while (idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time[k] - 1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) return;
            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) next = now + 1;
                if (i == 1) next = now - 1;
                if (i == 2) next = now * 2;

                if (next < 0 || next > 100000) continue;
                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}