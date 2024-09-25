import java.io.*;
import java.util.*;

public class Main {
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

        solve(1,0);

        System.out.print(sb);
    }

    static void solve(int cur, int cnt) {
        if (cnt == m) {
            for (int a: ans)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = cur; i <= n; i++) {
            ans[cnt] = i;
            solve(i + 1, cnt + 1);
        }
        
    }


}
