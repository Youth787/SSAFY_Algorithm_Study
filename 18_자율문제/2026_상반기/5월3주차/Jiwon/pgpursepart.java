import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length][2]; //0: 1부터시작, 1: -1부터시작.
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * -1;
        for (int i = 1; i < sequence.length; i++) {
            if (i % 2 == 0) { // 0: 1, 1: -1
                dp[i][0] = Math.max(dp[i - 1][0] + sequence[i], sequence[i]);
                dp[i][1] = Math.max(dp[i - 1][1] + sequence[i] * -1, sequence[i] * -1);
            } else { // 0: -1, 1: 1
                dp[i][0] = Math.max(dp[i - 1][0] + sequence[i] * -1, sequence[i] * -1);
                dp[i][1] = Math.max(dp[i - 1][1] + sequence[i], sequence[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        return answer;
    }
}
