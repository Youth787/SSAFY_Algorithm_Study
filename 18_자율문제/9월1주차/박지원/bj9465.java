//백준 스티커 자바
//DP

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            for (int i = 0; i < 2; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(temp[j]);
                }
            }
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);
            for (int i = 1; i < n; i++) {
                if (i == 1) {
                    dp[0][i] = dp[1][0] + sticker[0][1];
                    dp[1][i] = dp[0][0] + sticker[1][1];
                    max = Math.max(dp[0][i], dp[1][i]);
                    continue;
                }
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
                max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
            }
            System.out.println(max);
        }

    }


}
