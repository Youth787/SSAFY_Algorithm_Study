//백준 평범한 배낭 DP

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[] dp = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[i] = w;
            value[i] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = k; j - weight[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }


        System.out.println(dp[k]);

    }

}
