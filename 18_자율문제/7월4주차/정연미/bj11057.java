package Algo_스터디.July_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for (int i=0; i<10;i++) dp[0][i] = 1;

        for(int i=1; i<=N; i++){
            for(int j=9; j>=0; j--){
                if(j==9) dp[i][j] = 1;
                else dp[i][j] = (dp[i][j+1] + dp[i-1][j])%10007;
            }
        }

        System.out.println(dp[N][0]%10007);
    }
}
