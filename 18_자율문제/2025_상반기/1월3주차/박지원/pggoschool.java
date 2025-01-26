//프로그래머스 등굣길 자바
//dp

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for (int[] puddle: puddles) {
            map[puddle[1]][puddle[0]] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (map[i][1] == 1) {
                dp[i][1] = 0;
                break;
            }
            else dp[i][1] = 1;
        }
        for (int j = 2; j <= m; j++) {
            if (map[1][j] == 1) {
                dp[1][j] = 0;
                break;
            }
            else dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        return dp[n][m];
    }

}
