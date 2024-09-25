import java.io.*;
import java.sql.Array;
import java.util.*;

//1743. 음식물 피하기(dfs)
public class Main {
    static int n, m, k, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < n && my < m && map[mx][my] == 1 && !visited[mx][my]) {
                dfs(mx, my);
            }
        }
    }
}
