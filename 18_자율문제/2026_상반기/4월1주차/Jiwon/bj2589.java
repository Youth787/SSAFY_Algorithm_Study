import java.util.*;
import java.io.*;

public class bj2589 {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    answer = Math.max(findFar(i, j), answer);
                }
            }
        }


        System.out.println(answer);


    }
    static int findFar(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        int move = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (move < now[2]) move = now[2];
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if (mx >= 0 && my >= 0 && mx < n && my < m && !visited[mx][my] && map[mx][my] == 'L') {
                    visited[mx][my] = true;
                    q.add(new int[]{mx, my, now[2] + 1});
                }
            }
        }
        return move;
    }

}