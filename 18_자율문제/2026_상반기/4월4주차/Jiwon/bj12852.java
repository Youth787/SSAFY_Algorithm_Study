import java.io.*;
import java.util.*;

public class bj12852 {
    public static int n;
    public static int[] parent, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[1000001];
        cnt = new int[1000001];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[n] = 0;

        bfs();
        Stack<Integer> s = new Stack<>();
        int idx = 1;
        while (idx != n) {
            s.push(idx);
            idx = parent[idx];
        }
        s.push(n);
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(cnt[1]);
        System.out.println(sb);

    }
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 1) return;
            if (now % 3 == 0 && cnt[now / 3] > cnt[now] + 1) {
                if (now / 3 == 0) continue;
                q.add(now / 3);
                cnt[now / 3] = cnt[now] + 1;
                parent[now / 3] = now;
            }
            if (now % 2 == 0 && cnt[now / 2] > cnt[now] + 1) {
                if (now / 2 == 0) continue;
                q.add(now / 2);
                cnt[now / 2] = cnt[now] + 1;
                parent[now / 2] = now;
            }
            if (now > 1 && cnt[now - 1] > cnt[now] + 1) {
                q.add(now - 1);
                cnt[now - 1] = cnt[now] + 1;
                parent[now - 1] = now;
            }
        }
    }
}