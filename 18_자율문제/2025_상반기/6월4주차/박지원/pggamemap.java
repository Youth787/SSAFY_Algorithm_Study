//프로그래머스 게임 맵 최단거리 자바
//bfs/ dfs는 시간초과

import java.util.*;

class Solution {
    private static int n, m, answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i][j];
            }
        }
        bfs();
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == n - 1 && now[1] == m - 1) {
                answer = Math.min(answer, now[2]);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int mx = dx[i] + now[0];
                int my = dy[i] + now[1];
                if (mx < 0 || my < 0 || mx >= n || my >= m) continue;
                if (visited[mx][my] || map[mx][my] == 0) continue;
                visited[mx][my] = true;
                q.add(new int[]{mx, my, now[2] + 1});
            }
        }
        

        
    }
}
