//백준 LCS2 자바
//DP

import java.util.*;
import java.io.*;

public class Main {
    private static int len1, len2;
    private static int[][] dp;
    private static String str1, str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        len1 = str1.length();
        len2 = str2.length();
        int answer = getLength();
        StringBuilder sb = new StringBuilder();
        while (len1 > 0 && len2 > 0) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                sb.insert(0, str1.charAt(len1 - 1));
                len1--;
                len2--;
            } else if (dp[len1][len2] == dp[len1 - 1][len2]) len1--;
            else if (dp[len1][len2] == dp[len1][len2 - 1]) len2--;
        }
        if (answer == 0) return;
        System.out.println(answer);
        System.out.println(sb.toString());
    }
    private static int getLength() {
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }

}
