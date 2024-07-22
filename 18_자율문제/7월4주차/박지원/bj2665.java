// 백준 미로만들기 자바
// BFS

import java.io.*;
import java.util.*;

public class Main{
    private static class Node implements Comparable<Node> {
        int x, y, count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node n) {
            return this.count - n.count;
        }
    }
    private static int n;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static int min = Integer.MAX_VALUE;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0' == 1;
            }
        }
        BFS();
        System.out.println(min);
    }
    static void BFS() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.x == n - 1 && now.y == n - 1) {
                min = Math.min(min, now.count);
            }
            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                if (mx >= 0 && my >= 0 && mx < n && my < n && !visited[mx][my]) {
                    visited[mx][my] = true;
                    if (map[mx][my]) pq.add(new Node(mx, my, now.count));
                    else pq.add(new Node(mx, my, now.count + 1));
                }
            }
        }



    }
}
