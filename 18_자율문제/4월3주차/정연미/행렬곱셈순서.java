package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 너무 어려운데요 
public class 행렬곱셈순서 {
    static int N, INF = Integer.MAX_VALUE;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = a; arr[i+1] = b;
        } // 입력받기 완료

        dp = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], INF);
        }
        System.out.println(solve(0,N-1));
    }
    public static int solve(int pos, int curr){
        if(pos == curr ) return 0;
        if(dp[pos][curr] != INF ) return dp[pos][curr];

        for(int i=pos; i<curr; i++){
            int value = solve(pos,i) + solve(i+1,curr) + arr[pos]*arr[i+1]*arr[curr+1];
            dp[pos][curr] = Math.min(dp[pos][curr],value);
        }
        return dp[pos][curr];
    }
}

