//백준 로봇청소기 자바
//DFS, 구현, 시뮬레이션

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, r, c, d, answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        answer = 1;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(answer);
    }
// 북동남서 0123
    private static void dfs(int x, int y, int di) {
        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            //청소할 곳 있으면 방향 전환
            di = (di + 3) % 4;
            int mx = x + dx[di];
            int my = y + dy[di];
            if (mx >= 0 && my >= 0 && mx < n && my < m && map[mx][my] == 0) {
                answer++;
                dfs(mx, my, di);
                //청소했으면 뒤에 코드 실행 금지
                return;
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인경우
        //뒤 쪽 칸이 벽이 아니라는 전제 하에 바라보는 방향을 유지한 채로 한 칸 후진.
        int back = (di + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx>= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, di);
        }
    }
}
