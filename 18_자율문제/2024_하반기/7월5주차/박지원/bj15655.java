import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static int[] arr, ans;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(0, 0);

        System.out.println(sb);

    }
    private static void solve(int idx, int count) {
        if (count == m) {
            for (int a: ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx >= n) return;
        
        ans[count] = arr[idx];
        solve(idx + 1, count + 1);
        solve(idx + 1, count);
        
    }

}
