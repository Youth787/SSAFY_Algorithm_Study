//백준 미로 탐색 자바
//BFS, dfs로 풀면 시간초과남 ㅠ dfs연습하려고 가져왔는데!!! 그래도 테케 정답은 다 맞았따

import java.io.*;
import java.util.*;

public class Main{
    private static class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        visited[0][0] = true;
        BFS();
        System.out.println(map[n - 1][m - 1]);

    }
    private static void BFS() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                if (mx >= 0 && my >= 0 && mx < n && my < m && map[mx][my] == 1 && !visited[mx][my]) {
                    q.add(new Node(mx, my));
                    map[mx][my] += map[now.x][now.y];
                    visited[mx][my] = true;
                }
            }
        }

    }


}
