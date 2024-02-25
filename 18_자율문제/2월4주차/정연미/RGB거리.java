package Algo_스터디.Fev_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
    static int[][] dp, cost;
    static int N;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1][3];

        for(int i=1 ; i<=N;  i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j]= Integer.parseInt(st.nextToken());
            }
        }// 입력받기 완료

        dp = new int[N+1][3];
        for(int i=0; i<3; i++) calcost(N,i);
        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));
    }
    public static int calcost(int r, int color){
        if(r==1) return cost[r][color];

        if(dp[r][color]==0) {// 탐색하지 않은 배열일 경우.
            if (color == 0) {
                dp[r][color] = cost[r][color] + Math.min(calcost(r - 1, 1), calcost(r - 1, 2));
            } else if (color == 1) {
                dp[r][color] = cost[r][color] + Math.min(calcost(r - 1, 0), calcost(r - 1, 2));
            } else {
                dp[r][color] = cost[r][color] + Math.min(calcost(r - 1, 0), calcost(r - 1, 1));
            }
        }
        return dp[r][color];
    }
}
