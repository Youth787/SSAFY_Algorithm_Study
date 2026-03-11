import java.util.*;
import java.io.*;

public class bj1054 {
    static int f, s, g, u, d, answer;
    static int[] floor;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        floor = new int[f + 1];
        Arrays.fill(floor, Integer.MAX_VALUE);
        goStairs();

    }
    static void goStairs() {
        // 현재위치, 횟수
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        floor[s] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == g) {
                System.out.println(floor[g]);
                return;
            }
            int next = now + u;
            if (next >= 1 && next <= f && floor[next] > floor[now] + 1) {
                q.add(next);
                floor[next] = floor[now] + 1;
            }

            next = now - d;
            if (next >= 1 && next <= f && floor[next] > floor[next] + 1) {
                q.add(next);
                floor[next] = floor[now] + 1;
            }
        }
        System.out.println("use the stairs");
    }
}