import java.util.*;
import java.io.*;

public class Main {
    private static int n, answer;
    private static int[][] map;
    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] target = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            answer = Integer.MAX_VALUE;
            move(start, target);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    private static void move(int[] s, int[] t) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{s[0], s[1], 0});
        visited[s[0]][s[1]] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == t[0] && now[1] == t[1]) {
                answer = Math.min(answer, now[2]);
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= n) continue;
                if (visited[mx][my]) continue;
                q.add(new int[]{mx, my, now[2] + 1});
                visited[mx][my] = true;
            }
        }
    }

}
