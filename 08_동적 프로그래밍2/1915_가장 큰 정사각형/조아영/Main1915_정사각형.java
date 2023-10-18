import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2023.10.17.DP2
//https://simju9397.tistory.com/27
public class Main1915_정사각형 {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N,M, max;
    private static int[][] arr, dp;
    private static void input() throws IOException {
        StringTokenizer nm = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(nm.nextToken());
        M = Integer.parseInt(nm.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for(int i = 0 ; i < N; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for(int j = 0 ; j < M; j++) {
                arr[i][j] = Character.getNumericValue(line[j]);
                dp[i][j] = arr[i][j];
                if(i >= 1 && j >= 1) {
                    if(dp[i-1][j] > 0 && dp[i-1][j-1] > 0 && dp[i][j-1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() throws IOException {
        System.out.println(max * max);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
	
	
}