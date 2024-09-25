package GOLD.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리2 {
    static int[][] dp,arr;
    static final int MAX = 1000*1000+1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];
        dp = new int[N+1][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = MAX;

        for(int start =0; start<3; start++){
            for(int i=0; i<3; i++){
                if(start == i) dp[1][i] = arr[1][i];
                else dp[1][i] = MAX;
            }
            for(int i=2; i<=N; i++){
                    dp[i][0] = arr[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
                    dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
                    dp[i][2] = arr[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
                }
            for(int i=0; i<3; i++){
                if(i!=start && min>dp[N][i]){
                    min = dp[N][i];
                }
            }
        }
        System.out.println(min);
    }
}
