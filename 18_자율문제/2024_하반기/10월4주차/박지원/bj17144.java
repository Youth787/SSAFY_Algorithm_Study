//백준 미세먼지 안녕! 자바
//구현 + 시뮬레이션 / bfs

import java.io.*;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        int x, y, dust;

        public Node(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }

        @Override
        public int compareTo(Node n) {
            return n.dust - this.dust;
        }
    }
    private static int r, c, t;
    private static Node[] cleaner;
    private static int[][] map, spread;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[] cleanerX, cleanerY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        spread = new int[r][c];
        cleaner = new Node[2];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (cleaner[0] == null) cleaner[0] = new Node(i, j, -1);
                    else cleaner[1] = new Node(i, j, -1);
                }
            }
        }

        while (t-- > 0) {
            spread = new int[r][c];
            dirtyAir();
            cleanAir();
        }
        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) continue;
                answer += map[i][j];
            }
        }
        System.out.println(answer);

    }
    //미세먼지 확산
    private static void dirtyAir() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    q.add(new Node(i, j, map[i][j]));
                }
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            int temp = now.dust / 5;
            if (temp <= 0) continue;
            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                if (mx < 0 || my < 0 || mx >= r || my >= c) continue;
                if (map[mx][my] == -1) continue;
                spread[mx][my] += temp;
                spread[now.x][now.y] -= temp;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += spread[i][j];
            }
        }
    }
    //공기청정기 돌리세요
    private static void cleanAir() {
        for (int i = cleaner[0].x; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = cleaner[1].x; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < cleaner[0].x; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[cleaner[0].x][i] = map[cleaner[0].x][i - 1];
        }
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        for (int i = r - 1; i > cleaner[1].x; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[cleaner[1].x][i] = map[cleaner[1].x][i - 1];
        }
        map[cleaner[0].x][1] = 0;
        map[cleaner[1].x][1] = 0;
        map[cleaner[0].x][0] = -1;
        map[cleaner[1].x][0] = -1;
    }
}
