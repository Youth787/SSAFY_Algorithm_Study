//백준 사이클게임 자바
//분리집합, union, find

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                System.out.println(i);
                return;
            } else union(a, b);

        }
        System.out.println(answer);
    }
    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

}
