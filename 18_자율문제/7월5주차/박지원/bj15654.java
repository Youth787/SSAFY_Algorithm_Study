import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static int[] arr, ans;
    private static StringBuilder sb;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(0);

        System.out.println(sb);

    }
    private static void solve(int count) {
        if (count == m) {
            for (int a: ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[count] = arr[i];
                solve(count + 1);
                visited[i] = false;
            }
        }
    }

}
