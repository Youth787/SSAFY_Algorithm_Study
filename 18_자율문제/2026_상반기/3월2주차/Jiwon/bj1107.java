import java.util.*;
import java.io.*;

public class bj1107 {
    static int  n, m, count;
    static boolean[] error;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        error = new boolean[10]; // 0~9
        if (n == 100) {
            System.out.println(0);
            return;
        }
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }
        count = Math.abs(100 - n);
        dfs(0, 0); // 완전탐색해주기
        System.out.println(count);

    }
    static void dfs(int idx, int click) {
        for (int i = 0; i < 10; i++) {
            if (!error[i]) {
                int newBtn = click * 10 + i;
                int cnt = Math.abs(n - newBtn) + String.valueOf(newBtn).length();
                count = Math.min(count, cnt);

                if (idx < 5) dfs(idx + 1, newBtn);
            }
        }
    }

}