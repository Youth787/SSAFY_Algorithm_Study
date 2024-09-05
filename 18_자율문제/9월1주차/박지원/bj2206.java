//백준 벽 부수고 이동하기 자바
//BFS+여러조건 / 그냥 단순히 벽을 한번 부셨는지 아닌지 체크하면서 하면 될 줄 알았느ㅜㄴ데, 아니였다.
//벽 안부수고 도착점에 먼저 도달할 수 있기 떄문에 벽을 부실떄, 안부실때를 따로 구분해줘야한다.

import java.io.*;
import java.util.*;

public class Main{
    private static class Point {
        int x, y, cnt;
        boolean destroyed;
        public Point(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
    private static int n, m;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
            }
        }
        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        q.add(new Point(1, 1, 1, false));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == n && now.y == m) {
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                int next_cnt = now.cnt+1;
                if (mx <= 0 || my <= 0 || mx > n || my > m) continue;
                if (map[mx][my] == 0) {
                    if (!visited[mx][my][0] && !now.destroyed) { // 부신벽이 없다면 ?
                        q.add(new Point(mx, my, next_cnt, false));
                        visited[mx][my][0] = true;
                    } else if (now.destroyed && !visited[mx][my][1]) { //벽을 한번 부셨으면 ?
                        q.add(new Point(mx, my, next_cnt, true));
                        visited[mx][my][1] = true;
                    }
                } else {
                    if (!now.destroyed) {
                        q.add(new Point(mx, my, next_cnt, true));
                        visited[mx][my][1] = true;
                    }
                }
            }
        }


        return -1;
    }

}
