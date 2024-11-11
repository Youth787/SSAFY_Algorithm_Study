package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] process = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            process[i][0] = Integer.parseInt(st.nextToken());
            process[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int k=1; k<N; k++) {
            for(int i=0; i+k<N; i++) {
                dp[i][i+k] = Integer.MAX_VALUE;
                for(int j=i; j<i+k; j++)
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k] + process[i][0]*process[j][1]*process[i+k][1]);
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
