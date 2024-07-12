//백준 15649 N과 M 자바
//아직도 순열고 ㅏ조합이 어렵습니다..

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] arr, ans;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        solve(0);
        System.out.println(sb);
    }
    public static void solve(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[cnt] = arr[i];
            solve(cnt + 1);
            visited[i] = false;
        }

    }
}

