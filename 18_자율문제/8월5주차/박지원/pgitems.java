//프로그래머스 아이템줍기 LV3
//BFS, 테두리를 볼 땐 뭐든지 2배씩 높여라!

import java.util.*;

class Solution {
    private static char[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new char[101][101];
        for (int[] arr: rectangle) {
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            makeRect(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }
        
        return BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    private static void makeRect(int r, int c, int x, int y) {
        for (int i = r; i <= x; i++) {
            for (int j = c; j <= y; j++) {
                if(map[i][j]=='1') continue;
                map[i][j] = '1';
                if (i == r || i == x || j == c || j == y) map[i][j] = '2';
            }
        }
    }
    private static int BFS(int startX, int startY, int endX, int endY) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new Integer[]{startX, startY, 0});
        visited[startX][startY] = true;
        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            if(now[0] == endX && now[1] == endY)
                return now[2] / 2;
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || my < 0 || mx >= map.length || my >= map[0].length) continue;
                if (visited[mx][my] || map[mx][my] != '2') continue;
                visited[mx][my] = true;
                q.add(new Integer[]{mx, my, now[2] + 1});
            }
        }
        return 0;
    }
}
