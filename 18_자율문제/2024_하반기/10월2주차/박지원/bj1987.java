// 백준 알파벳 자바
// DFS+SET

import java.io.*;
import java.util.*;

public class Main{
    private static class Point {
        int x, y;
        char c;
        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    private static int r, c, answer;
    private static char[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        boolean[][] visited = new boolean[r][c];
        HashSet<Character> set = new HashSet<>();
        set.add(map[0][0]);
        visited[0][0] = true;
        DFS(set, visited, new Point(0, 0, map[0][0]));
        System.out.println(answer);
    }
    private static void DFS(HashSet<Character> list, boolean[][] visited, Point now) {
        answer = Math.max(answer, list.size());
        visited[now.x][now.y] = true;
        list.add(now.c);
        for (int i = 0; i < 4; i++) {
            int mx = now.x + dx[i];
            int my = now.y + dy[i];
            if (mx < 0 || my < 0 || mx >= r || my >= c) continue;
            if (visited[mx][my] || list.contains(map[mx][my])) continue;
            visited[mx][my] = true;
            list.add(map[mx][my]);
            DFS(list, visited, new Point(mx, my, map[mx][my]));
            visited[mx][my] = false;
            list.remove(map[mx][my]);
        }
    }
}
