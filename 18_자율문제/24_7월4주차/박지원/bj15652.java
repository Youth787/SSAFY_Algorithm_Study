//백준 N과 M4 자바
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
        solve(1, 0);
        System.out.println(sb);
    }
    static void solve(int idx, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i <= n; i++) {
            ans[count] = i;
            solve(i, count + 1);
        }

    }
}

