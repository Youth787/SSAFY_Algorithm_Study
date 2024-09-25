package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = arr[1];

        for(int i=2; i<=N; i++){
            dp[i] = arr[i];
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+arr[i],dp[i]);
                }
            }
        }
        int max =Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}
