//백준 점프 자바
//DP (dfs는 시간초과!)

import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) break;
                if (j + map[i][j] < n) dp[i][j + map[i][j]] += dp[i][j];
                if (i + map[i][j] < n) dp[i + map[i][j]][j] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }



}
