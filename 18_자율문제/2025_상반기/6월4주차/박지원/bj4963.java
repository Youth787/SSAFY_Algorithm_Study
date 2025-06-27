//백준 섬의개수 자바
//bfs

import java.io.*;
import java.util.*;

public class Main {
    private static int w, h, answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    private static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[w][h];
            visited = new boolean[w][h];
            answer = 0;
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
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
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if (mx < 0 || my < 0 || mx >= w || my >= h) continue;
                if (visited[mx][my] || map[mx][my] == 0) continue;
                visited[mx][my] = true;
                q.add(new int[]{mx, my});

            }
        }
    }
}
