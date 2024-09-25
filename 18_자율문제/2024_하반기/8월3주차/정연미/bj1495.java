package Algo_스터디.August_3주차;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class bj1495 {
    static int N,S,M;
    static boolean[][] dp;
    static int[] arr;
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        dp = new boolean[N+1][M+1];
        arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[0][S] = true;

        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i-1][j]){
                    if(j+arr[i]<=M) dp[i][j+arr[i]] = true;
                    if(j-arr[i]>=0) dp[i][j-arr[i]] = true;
                }
            }
        }

        int result = -1;
        for(int i=M; i>=0; i--) if(dp[N][i]) result = Math.max(result, i);
        System.out.println(result);
    }
}
