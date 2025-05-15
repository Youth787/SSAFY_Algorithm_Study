//백준 도시 분할 계획 자바
//최소 스패닝 트리, 그래프이론 (union, find)

import java.io.*;
import java.util.*;

public class Main {
    private static class Road implements Comparable<Road> {
        int to, from, v;

        public Road (int from, int to, int v) {
            this.from = from;
            this.to = to;
            this.v = v;
        }

        @Override
        public int compareTo(Road r) {
            return this.v - r.v;
        }
    }
    private static int n, m;
    private static ArrayList<Road> list = new ArrayList<>();
    private static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Road(a, b, c));

        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        Collections.sort(list);
        int answer = 0;
        int bigCost = 0;
        for (int i = 0; i < list.size(); i++) {
            Road r = list.get(i);

            if (find(r.from) != find(r.to)) {
                answer += r.v;
                union(r.from, r.to);

                bigCost = r.v;
            }
        }
        System.out.println(answer - bigCost);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

}

