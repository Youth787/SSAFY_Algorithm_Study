import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, answer;
    private static int[][] map, dp;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(0, 0));
    }
    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            //방문했음
            return dp[x][y];
        } else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
                if (map[mx][my] < map[x][y]) dp[x][y] += dfs(mx, my);
            }
        }

        return dp[x][y];
    }
}
