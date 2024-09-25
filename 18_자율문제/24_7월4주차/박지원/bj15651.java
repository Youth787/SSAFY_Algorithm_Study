//백준 N과M3 자바

import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static int[] ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        ans = new int[m];
        solve(0);
        System.out.println(sb);
    }
    static void solve(int count) {
        if (count > m) return;
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            ans[count] = i + 1;
            solve(count + 1);

        }

    }
}

