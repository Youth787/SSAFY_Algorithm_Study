import java.io.*;
import java.util.*;


//n과 m(5)
public class Main {
    static int n, m;
    static int[] num, ans;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n + 1];
        visited = new boolean[n + 1];
        ans = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        solve(0);
        bw.flush();
        bw.close();

    }
    static void solve(int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 1; i <= m; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[cnt + 1] = num[i];
                solve(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
