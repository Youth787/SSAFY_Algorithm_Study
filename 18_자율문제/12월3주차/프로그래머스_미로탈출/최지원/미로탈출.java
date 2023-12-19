import java.util.*;

class Solution {
    static class Point {
        int r;
        int c;
        int cnt; // 이전의 time을 cnt로 변경

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt; // 생성자에서도 변경
        }
    }

    static char[][] map;
    static int answer;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        int sr = 0; // 시작 위치의 행
        int sc = 0; // 시작 위치의 열
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
            }
        }

        answer = findRoute(sr, sc, 'L');

        return answer;
    }

    private static int findRoute(int r, int c, char goal) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length]; // visit을 visited로 변경

        visited[r][c] = true; // visit을 visited로 변경
        queue.add(new Point(r, c, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll(); // curr를 now로 변경

            if (map[now.r][now.c] == goal) {
                if (goal == 'L') {
                    int f = findRoute(now.r, now.c, 'E'); // curr를 now로 변경
                    if (f == -1) {
                        return -1;
                    } else {
                        return now.cnt + f; // time을 cnt로 변경
                    }
                } else {
                    return now.cnt; // time을 cnt로 변경
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] == 'X'
                        || visited[nr][nc]) { // visit을 visited로 변경
                    continue;
                }

                queue.add(new Point(nr, nc, now.cnt + 1)); // time을 cnt로 변경
                visited[nr][nc] = true; // visit을 visited로 변경
            }
        }

        return -1;
    }
}
