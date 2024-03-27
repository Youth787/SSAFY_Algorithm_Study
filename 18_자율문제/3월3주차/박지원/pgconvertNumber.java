import java.util.*;

//프로그래머스 숫자변환하기 dp
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == -1) continue;
            if (n + i <= y) {
                if (dp[n + i] == -1) {
                    dp[n + i] = dp[i] + 1;    
                } else dp[n + i] = Math.min(dp[n + i], dp[i] + 1);
            }
            if (2 * i <= y){
                if(dp[2 * i] == -1) {
                    dp[2 * i] = dp[i] + 1;
                }else dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);
            }
            if (3 * i <= y) {
                if (dp[3 * i] == -1) {
                    dp[3 * i] = dp[i] + 1;
                } else  dp[3 * i] = Math.min(dp[3 * i], dp[i] + 1);
            }
               
        }
        
        
        return dp[y];
    }
}

