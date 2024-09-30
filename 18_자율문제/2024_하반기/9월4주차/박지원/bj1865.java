//백준 웜홀 자바
//벨만포드 알고리즘

import java.io.*;
import java.util.*;

public class Main{
    private static class Point {
        int to, time;
        public Point(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
    private static int n, m, w;
    private static int[] dist;
    private static ArrayList<ArrayList<Point>> list;
    private static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            dist = new int[n + 1];
            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (i < m) {
                    list.get(s).add(new Point(e, t));
                    list.get(e).add(new Point(s, t));
                } else {
                    list.get(s).add(new Point(e, -t));
                }
            }

            boolean isMinus = false;
            for (int i = 1; i <= n; i++) {
                if (bellmanFord(i)) {
                    isMinus = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!isMinus) sb.append("NO\n");

        }
        System.out.println(sb.toString());
    }
    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for (int i = 1; i < n; i++) {
            update = false;

            for (int j = 1; j <= n; j++) {
                for (Point p: list.get(j)) {
                    if (dist[j] != INF && dist[p.to] > dist[j] + p.time) {
                        dist[p.to] = dist[j] + p.time;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        if (update) {
            for (int i = 1; i <= n; i++) {
                for (Point p: list.get(i)) {
                    if (dist[i] != INF && dist[p.to] > dist[i] + p.time) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
