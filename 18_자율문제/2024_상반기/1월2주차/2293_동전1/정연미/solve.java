package Algo_스터디.Jan_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        for(int i=0; i<N; i++) money[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[K+1];
        for(int i=0; i<N; i++){
            for(int j=1; j<=K; j++){
                if(money[i]<=j){
                    if(j-money[i]==0) dp[j] = dp[j]+1;
                    else dp[j] = dp[j-money[i]] + dp[j];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);
    }
}
