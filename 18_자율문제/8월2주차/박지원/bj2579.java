//백준 계단오르기 자바
// DP+재귀함수

import java.io.*;
import java.util.*;

public class Main{
    private static int stairs[];
    private static Integer dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp = new Integer[n + 1];
        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if (n >= 2) dp[2] = stairs[2] + stairs[1];
        System.out.println(find(n));


    }
    private static int find(int x) {
        if (dp[x] == null) {
            dp[x] = Math.max(find(x - 2), find(x - 3) + stairs[x - 1]) + stairs[x];
        }
        return dp[x];
    }

}
