//백준 평범한배낭 자바
//DP2차원 (근데 이전엔 1차원으로도 풀었떠라 그게 더 쉬움)

import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] item = new int[n + 1][2];  // weight, value

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int j = 1; j<= k; j++) { // 무게
            for (int i = 1; i <= n; i++) { // item
                dp[i][j] = dp[i - 1][j];
                if (j - item[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], item[i][1] + dp[i - 1][j - item[i][0]]);
                }
            }
        }

        System.out.println(dp[n][k]);

    }

}
