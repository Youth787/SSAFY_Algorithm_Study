import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        int m = 0;
        for (int h = 0; h < max + 1; h++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        cnt += dfs(i, j, h);
                    }
                }
            }
            m = Math.max(m, cnt);
        }
        System.out.println(m);
        
        
    }
    private static int dfs(int x, int y, int h) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = dx[i] + x;
            int my = dy[i] + y;
            if (mx < 0 || my < 0 || mx >= n || my >= n) continue;
            if (visited[mx][my]) continue;
            if (map[mx][my] > h) dfs(mx, my, h);
        }
        return 1;
    }
}
