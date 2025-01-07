//백준 RGB거리 2 자바
//조건 있는 DP


import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        int[][] house = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int result = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    dp[n - 1][j] = 1000001;
                    continue;
                }
                dp[n - 1][j] = house[n - 1][j];
            }
            for (int j = n - 2; j > 0; j--) {
                dp[j][0] = Math.min(dp[j + 1][1], dp[j + 1][2]) + house[j][0];
                dp[j][1] = Math.min(dp[j + 1][0], dp[j + 1][2]) + house[j][1];
                dp[j][2] = Math.min(dp[j + 1][0], dp[j + 1][1]) + house[j][2];
            }
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                result = Math.min(result, house[0][i] + dp[1][j]);
            }
            answer = Math.min(answer, result);
        }
        System.out.println(answer);
    }

}
