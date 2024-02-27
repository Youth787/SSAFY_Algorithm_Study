import java.util.*;

//프로그래머스 거스름돈 dp
class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i: money) {
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }
        }
        return dp[n] % 1000000007;
    }

}

//https://tosuccess.tistory.com/57
