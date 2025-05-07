//백준 그림 자바
//bfs

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0 ,1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    int temp = bfs(i, j, 1);
                    max = Math.max(temp, max);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(max);
        System.out.println(sb.toString());
    }
    private static int bfs(int x, int y, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, count});
        int max = 0;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            max = Math.max(max, now[2]);
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
                if (visited[mx][my] || map[mx][my] == 0) continue;
                visited[mx][my] = true;
                q.add(new int[]{mx, my, ++count});
            }
        }
        return max;
    }

}

