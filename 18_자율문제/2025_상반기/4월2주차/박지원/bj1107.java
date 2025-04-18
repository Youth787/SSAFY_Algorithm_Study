//백준 리모컨 자바
//dfs, 완전탐색, 구현

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, count;
    private static boolean[] broke;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        broke = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int cur = Integer.parseInt(st.nextToken());
                broke[cur] = true;
            }
        }
        if (n == 100) {
            System.out.println(0);
            return;
        }
        count = Math.abs(n - 100);
        
        dfs(0, 0);
        System.out.println(count);
        

    }
    private static void dfs(int idx, int click) {
        for (int i = 0; i < 10; i++) {
            if (!broke[i]) {
                int newBtn = click * 10 + i;
                int cnt = Math.abs(n - newBtn) + String.valueOf(newBtn).length();
                count = Math.min(count, cnt);
                
                if (idx < 6) {
                    dfs(idx + 1, newBtn);
                }
            }
        }
    }

}

