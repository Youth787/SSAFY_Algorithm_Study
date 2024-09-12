//백준 파도반수열 자바
//DP

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 3) {
                System.out.println(1);
            } else {
                long[] dp = new long[n + 1];
                dp[1] = 1;
                dp[2] = 1;
                dp[3] = 1;
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 3] + dp[i - 2];
                }
                System.out.println(dp[n]);
            }
        }
    }
}
