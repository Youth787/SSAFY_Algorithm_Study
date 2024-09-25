//백준 RGB거리 자바
//DP 반복문

import java.io.*;
import java.util.*;

public class Main{
    private static int Red = 0;
    private static int Green = 1;
    private static int Blue = 2;
    private static int[][] cost, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[3][n];
        cost = new int[3][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            cost[Red][i] = red;
            cost[Green][i] = green;
            cost[Blue][i] = blue;
        }
        dp[Red][0] = cost[Red][0];
        dp[Green][0] = cost[Green][0];
        dp[Blue][0] = cost[Blue][0];
        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.  
        for (int i = 1; i < n; i++) {
            cost[Red][i] += Math.min(cost[Green][i - 1], cost[Blue][i - 1]);
            cost[Green][i] += Math.min(cost[Red][i - 1], cost[Blue][i - 1]);
            cost[Blue][i] += Math.min(cost[Red][i - 1], cost[Green][i - 1]);
        }

        System.out.println(Math.min(cost[Green][n - 1], Math.min(cost[Red][n - 1], cost[Blue][n - 1])));
}

}

