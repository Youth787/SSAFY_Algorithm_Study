import java.io.*;
import java.sql.Array;
import java.util.*;

//단지번호붙이기 dfs
public class Main {
    static int n, cnt, total;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 0;
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    solve(i, j);
                    if (cnt > 0) {
                        total++;
                        answer.add(cnt);
                    }
                    cnt = 0;
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int a: answer) System.out.println(a);

    }
    static void solve(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < n && my < n && !visited[mx][my] && map[mx][my] == 1) {
                visited[mx][my] = true;
                cnt++;
                solve(mx, my);
            }
        }
    }
}
