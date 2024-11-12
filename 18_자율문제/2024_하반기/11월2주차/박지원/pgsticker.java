//프로그래머스 스티커모으기(2) 자바
//DP

import java.util.*;

class Solution {
    private static int answer;
    public int solution(int sticker[]) {
        int[] dp = new int[sticker.length];
        int len = sticker.length;
        if (len == 1) return sticker[0];
        //첫장 사용
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = dp[len - 2];

        //첫장 안사용
        dp[0] = 0;
        dp[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = Math.max(answer, dp[len - 1]);
        
        return answer;
    }

}
