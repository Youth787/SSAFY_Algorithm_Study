//백준 트리의 지름 자바
// DFS, 입력처리 까다로움,,

import java.io.*;
import java.util.*;

public class Main{
    private static class Point {
        int to, weight;
        public Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
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
            int currentNode = Integer.parseInt(str[0]);
            int index = 1;
            while (index < str.length) {
                int to = Integer.parseInt(str[index]);
                if (to == -1) break; // -1 입력 시 종료
                int weight = Integer.parseInt(str[index + 1]);
                list[currentNode].add(new Point(to, weight));
                index += 2;
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
