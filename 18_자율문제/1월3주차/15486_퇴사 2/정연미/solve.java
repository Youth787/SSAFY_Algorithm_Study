package Algo_스터디.Jan_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] TP = new int[N+1][2];
        for(int i=1; i<=N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            TP[i][0] = Integer.parseInt(st.nextToken());
            TP[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];
        int max =Integer.MIN_VALUE;
        int ans =0;

        for(int i=1; i<=N; i++){
           max = Math.max(max, dp[i]);
           int next = i+TP[i][0];
           if(next<N+2){
               dp[next] = Math.max(dp[next],max+TP[i][1]);
               ans = Math.max(ans,dp[next]);
           }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(ans);
    }
}
