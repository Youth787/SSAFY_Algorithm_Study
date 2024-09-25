//백준 테트로미노 자바
//DFS + ㅗ 방향 체크 두가지를 해줘야함

import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static int[][] map;
    private static int answer;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                DFS(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }
        System.out.println(answer);
    }
    private static void DFS(int x, int y, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < n && my < m && !visited[mx][my]) {
                visited[mx][my] = true;
                DFS(mx, my, count + 1, sum + map[mx][my]);
                visited[mx][my] = false;
            }
        }
    }
    private static void checkTShape(int x, int y) {
        // 각 T 모양에 대해 합을 계산
        if (x >= 1 && x < n - 1 && y >= 1 && y < m - 1) {
            // ㅗ 모양
            int sum = map[x][y] + map[x][y - 1] + map[x][y + 1] + map[x - 1][y];
            answer = Math.max(answer, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 0 && y < m - 1) {
            // ㅏ 모양
            int sum = map[x][y] + map[x - 1][y] + map[x][y + 1] + map[x + 1][y];
            answer = Math.max(answer, sum);
        }
        if (x >= 0 && x < n - 1 && y >= 1 && y < m - 1) {
            // ㅜ 모양
            int sum = map[x][y] + map[x][y + 1] + map[x][y - 1] + map[x + 1][y];
            answer = Math.max(answer, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 1 && y < m) {
            // ㅓ 모양
            int sum = map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x + 1][y];
            answer = Math.max(answer, sum);
        }
    }
}

