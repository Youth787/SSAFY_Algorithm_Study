import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int [n + 1];
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2 || n == 3) {
            System.out.println(1);
        } else {
          dp[0] = 0;
          dp[1] = 0;
          dp[2] = 1;
          dp[3] = 1;
          for (int i = 4; i <= n; i++) {
              if (i % 3 == 0 && i % 2 == 0) {
                  dp[i] = Math.min(dp[i / 2] + 1, Math.min(dp[i - 1] + 1, dp[i / 3] + 1));
              } else if (i % 3 == 0) {
                  dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
              } else if (i % 2 == 0) {
                  dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
              } else {
                  dp[i] = dp[i - 1] + 1;
              }
          }
          System.out.println(dp[n]);
      }
    }

}
