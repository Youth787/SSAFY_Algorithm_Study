//백준 치즈 자바
//구현 + DFS + BFS

import java.io.*;
import java.util.*;

public class Main{
    private static class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int n, m, cheese;
    private static int[][] map;
    private static ArrayList<Point> cheeseList;
    private static boolean[][] visited;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        cheeseList = new ArrayList<>();
        cheese = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseList.add(new Point(i, j));
                    cheese++;
                }

            }
        }
        int ans = 0;
        while (cheese != 0) {
            ans++;
            visited = new boolean[n][m];
            DFS(0, 0);
            melting();
        }
        System.out.println(ans);
    }
    private static void melting() {
        for (int i = 0; i < cheeseList.size(); i++) {
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int mx = x + dx[j];
                int my = y + dy[j];
                if (map[mx][my] == 2) cnt++;
            }
            if (cnt >= 2) {
                map[x][y] = 0;
                cheese--;
                cheeseList.remove(i);
                i--;
            }
        }
    }
//0, 0 부터 시작해서 공기와 맞닿은 치즈를 찾기
    private static void DFS(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
            if (visited[mx][my] || map[mx][my] == 1) continue;

            DFS(mx, my);
        }
    }
}
