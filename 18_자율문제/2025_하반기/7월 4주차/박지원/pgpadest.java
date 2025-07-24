import java.util.*;
//0: 자유 1: 못가, 2: 왼->오만가능
class Solution {
    private static int MOD = 20170805;
    private static int[][][] dp;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    public int solution(int M, int N, int[][] cityMap) {
        int answer = 0;
        dp = new int[M + 1][N + 1][2];
        //x, y, 0: 세로, 1: 가로
        dp[0][0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (cityMap[i][j] == 0) {
                    dp[i + 1][j][0] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                    dp[i][j + 1][1] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                } else if (cityMap[i][j] == 2) {
                    dp[i + 1][j][0] += dp[i][j][0];
                    dp[i + 1][j][0] %= MOD;
                    
                    dp[i][j + 1][1] += dp[i][j][1];
                    dp[i][j + 1][1] %= MOD;
                }
            }
        }
        return (dp[M - 1][N - 1][0] + dp[M - 1][N - 1][1]) % MOD;
    }
   
   
}
