//백준 ACM Craft  자바
//토폴로지 정렬 

import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            int[] b = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int bNum = Integer.parseInt(st.nextToken());
                list.get(a).add(bNum);
                b[bNum]++;
            }

            int w = Integer.parseInt(br.readLine());
            solve(b, list, w);
        }
    }

    private static void solve(int[] b, ArrayList<ArrayList<Integer>> list, int w) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = d[i];
            if (b[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + d[i]);
                b[i]--;

                if (b[i] == 0) q.offer(i);
            }
        }

        System.out.println(result[w]);
    }
}
