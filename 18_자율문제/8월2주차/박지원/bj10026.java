//백준 적록색약 자바
//단순 BFS문제

import java.io.*;
import java.util.*;

public class Main{
    private static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int n;
    private static char[][] map, map2;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        map2 = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'G') map2[i][j] = 'R';
                else map2[i][j] = map[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    BFS(map, i, j);
                }
            }
        }
        sb.append(count).append(" ");
        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    BFS(map2, i, j);
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
    private static void BFS(char[][] m, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0 ; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                if (mx >= 0 && my >= 0 && mx < n && my < n && !visited[mx][my] && m[now.x][now.y] == m[mx][my]) {
                    visited[mx][my] = true;
                    q.add(new Node(mx, my));
                }
            }
        }
    }
}
