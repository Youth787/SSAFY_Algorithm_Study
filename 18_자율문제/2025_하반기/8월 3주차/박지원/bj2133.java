    import java.util.*;
    import java.io.*;

    public class Main {
        private static int n;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            if (n % 2 == 0) {
                int[] dp = new int[n + 1];
                dp[0] = 1;
                dp[1] = 0;
                dp[2] = 3;
                for (int i = 4; i <= n; i += 2) {
                    dp[i] = dp[i - 2] * dp[2];
                    for (int j = i - 4; j >= 0; j -= 2) {
                        dp[i] = dp[i] + dp[j] * 2;
                    }
                }
                System.out.println(dp[n]);
            } else System.out.println(0);

        }

    }
