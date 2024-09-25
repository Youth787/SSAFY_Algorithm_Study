import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] > 0) {
                    int val = map[i][j];
                    if (val > 0) {
                        if (isValid(i + val)) dp[i + val][j] += dp[i][j];
                        if (isValid(j + val)) dp[i][j + val] += dp[i][j];
                    }
                }
            }
        }
        System.out.print(dp[N-1][N-1]);
    }
    static boolean isValid(int val) {
        return val < N;
    }
}
