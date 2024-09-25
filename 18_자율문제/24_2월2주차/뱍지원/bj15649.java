import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] num, ans;
    static boolean[] visited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        num = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
        }
        solve(0);
        
        System.out.println(sb);
    }

    static void solve(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[cnt] = num[i];
            solve(cnt + 1);
            visited[i] = false;
        }
    }


}
