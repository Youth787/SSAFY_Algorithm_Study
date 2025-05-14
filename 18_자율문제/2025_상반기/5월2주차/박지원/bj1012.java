//백준 유기농배추 자바
//BFS

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
                if (visited[mx][my] || map[mx][my] == 0) continue;
                q.add(new int[]{mx, my});
                visited[mx][my] = true;
            }
        }
    }
}
