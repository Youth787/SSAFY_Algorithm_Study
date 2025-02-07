//백준 행렬 곱셈 순서 자바
//DP, 재귀함수

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] data;
    private static int[][] dp;
    private static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        data = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            data[i] = r;
            data[i + 1] = c;
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], INF);
        System.out.println(solve(0, n - 1));
    }
    private static int solve(int pos, int cur) {
        if (pos == cur) return 0;
        if (dp[pos][cur] != INF) return dp[pos][cur];

        for (int i = pos; i < cur; i++) {
            int value = solve(pos, i) + solve(i + 1, cur) + (data[pos] * data[i + 1] * data[cur + 1]);
            dp[pos][cur] = Math.min(dp[pos][cur], value);
        }
        return dp[pos][cur];
    }

}
