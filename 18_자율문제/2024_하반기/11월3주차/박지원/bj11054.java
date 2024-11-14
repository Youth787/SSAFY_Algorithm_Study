//백준 가장 긴 바이토닉 수열 자바
// DP

import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp, reverseDp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        reverseDp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= dp[i]) dp[i] = dp[j] + 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            reverseDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && reverseDp[j] >= reverseDp[i]) reverseDp[i] = reverseDp[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i] + reverseDp[i] - 1);
        System.out.println(max);
    }

}
