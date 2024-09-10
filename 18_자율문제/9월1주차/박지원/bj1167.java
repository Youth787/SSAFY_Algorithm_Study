//백준 트리의 지름 자바
//DFS, 그래프

import java.io.*;
import java.util.*;

public class Main{
    private static class Point implements Comparable<Point> {
        int to, weight;
        public Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point p) {
            return p.weight - this.weight;
        }
    }
    private static int v;
    private static ArrayList<Point>[] list;
    private static boolean[] visited;
    private static int max = 0;
    private static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= v; i++) {
            String[] str = br.readLine().split(" ");
            int[] temp = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                temp[j] = Integer.parseInt(str[j]);
            }
            int cnt = 1;
            while (true) {
                list[i].add(new Point(temp[cnt], temp[cnt + 1]));
                cnt += 2;
                if (temp[cnt] == -1) break;
            }

        }
        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(node, 0);

        System.out.println(max);

    }
    private static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;
        for (int i = 0; i < list[x].size(); i++) {
            Point p = list[x].get(i);
            if (!visited[p.to]) {
                dfs(p.to, p.weight + len);
                visited[p.to] = true;
            }
        }
    }
}
