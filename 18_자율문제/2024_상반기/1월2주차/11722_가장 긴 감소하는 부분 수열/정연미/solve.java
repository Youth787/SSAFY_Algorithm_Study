package Algo_스터디.Jan_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP 풀이

public class 가장긴감소하는부분수열_DP {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[N];
            int max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                dp[i] = 1;
                for(int j=0; j<i; j++){
                    if(arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
