//백준 피리부는사나이 자바
//분리집합, dfs

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, count;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        parent = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                parent[i][j] = i * m + j;
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DFS(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(find(i, j));
            }
        }
        System.out.println(set.size());
    }
    private static void DFS(int x, int y) {
        if (map[x][y] == 'U' && find(x, y) != find(x - 1, y)) {
            union(x, y, x - 1, y);
            DFS(x - 1, y);
        } else if (map[x][y] == 'D' && find(x, y) != find(x + 1, y)) {
            union(x, y, x + 1, y);
            DFS(x + 1, y);
        } else if (map[x][y] == 'L' && find(x, y) != find(x, y - 1)) {
            union(x, y, x, y - 1);
            DFS(x,  y - 1);
        } else if (map[x][y] == 'R' && find(x, y) != find(x, y + 1)) {
            union(x, y, x, y + 1);
            DFS(x, y + 1);
        }
    }
    private static int find(int x, int y) {
        if (parent[x][y] == m * x + y) return m * x + y;
        else return parent[x][y] = find(parent[x][y] / m, parent[x][y] % m);
    }
    private static void union(int ax, int ay, int bx, int by) {
        int a = find(ax, ay);
        int b = find(bx, by);
        if (a < b) parent[b / m][b % m] = a;
        else parent[a / m][a % m] = b;
    }

}
//3 4
//DDRD
//DRDU
//RRRU
