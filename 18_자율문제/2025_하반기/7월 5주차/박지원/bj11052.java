    import java.util.*;
    import java.io.*;

    public class Main {
        private static int n;
        private static int[] p;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
                }

            }
            System.out.println(dp[n]);
        }




    }
