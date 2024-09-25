package GOLD.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N!=0){
            long[][] dp = new long[N+1][N+1];
            dp[1][0] = 1;
            for(int w=0; w<=N; w++){
                for(int h=0; h<=N; h++){
                    if(w<N)
                        dp[w+1][h] +=dp[w][h];
                    if(h<w)
                        dp[w][h+1] += dp[w][h];
                }
            }
            System.out.println(dp[N][N]);
            N = Integer.parseInt(br.readLine());
        }
    }
}
