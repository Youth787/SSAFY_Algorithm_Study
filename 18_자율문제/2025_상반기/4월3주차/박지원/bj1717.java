//자바 집합의 표현 백준
//유니온 파인드~~

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = a;
            if (flag == 0) { // 합치기
                union(a, b);
            } else { // 같은 집합인지 확인하기
                if (isSameParent(a, b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }

        }
        System.out.println(sb.toString());

    }
    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static boolean isSameParent(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return true;
        else return false;
    }
}

