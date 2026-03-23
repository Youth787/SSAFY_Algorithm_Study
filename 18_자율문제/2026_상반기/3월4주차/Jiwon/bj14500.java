import java.util.*;
import java.io.*;

public class bj14500 {
    static int n, m, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // i, j 모든 점에서 4번 dfs 돌리고 (앞 도형 4개 확인가능)
        // ㅗ 테트리스는 가운데걸 중심으로 방향 돌려서 확인해주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(answer);
    }
    static void dfs(int x, int y, int depth, int sum) { // 4가지 도형 확인가능
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
            if (visited[mx][my]) continue;
            visited[mx][my] = true;
            dfs(mx, my, depth + 1, sum + map[mx][my]);
            visited[mx][my] = false;
        }
    }
    static void check(int x, int y) { // ㅗ 모양 확인해주기
        int[] number = new int[8]; //위 오 아 왼
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || my < 0 || mx >= n || my >= m) {
                number[i] = -1;
                number[i + 4] = -1;
            } else {
                number[i] = map[mx][my];
                number[i + 4] = map[mx][my];
            }
        }
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int temp = map[x][y];
            for (int j = 0; j < 3; j++) {
                if (number[i + j] < 0) {
                    break;
                } else {
                    temp += number[i + j];
                }
            }
            sum = Math.max(sum, temp);

        }
        answer = Math.max(answer, sum);

    }
}