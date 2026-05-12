import java.util.*;

class Solution {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] map;
    public static boolean[][] visited;
    public static int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {

                    // 내부는 2로 표시
                    if (i > x1 && i < x2 && j > y1 && j < y2) {
                        map[i][j] = 2;
                    } 
                    // 테두리는 1로 표시
                    else {
                        // 이미 내부인 곳은 테두리로 바꾸면 안 됨
                        if (map[i][j] != 2) {
                            map[i][j] = 1;
                        }
                    }
                }
            }
        }

        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer / 2;
    }

    public static void bfs(int x, int y, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();

        visited[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == itemX && now[1] == itemY) {
                answer = now[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || my < 0 || mx > 100 || my > 100) continue;
                if (visited[mx][my]) continue;

                // 테두리만 이동
                if (map[mx][my] == 1) {
                    visited[mx][my] = true;
                    q.add(new int[]{mx, my, now[2] + 1});
                }
            }
        }
    }
}
