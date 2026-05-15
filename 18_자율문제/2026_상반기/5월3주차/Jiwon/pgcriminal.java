import java.util.*;

class Solution {
    static final int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int [][] dp = new int [size + 1][m];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= size; i++) {
            int a = info[i-1][0];
            int b = info[i-1][1];
            for (int j = 0; j < m; j++) {
                // a 선택 
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                // b 선택
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }    
        }
        int min = INF;
        for (int j = 0; j < m; j++) {
            min = Math.min(dp[size][j], min);
        }
        return min >= n ? -1 : min;
    }
}
