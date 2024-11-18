//백준 동물원 자바
//DP

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % 9901;
        }

        System.out.println(dp[n]);


    }
}
