//백준 RGB거리 자바
//DP

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

        System.out.println(Math.min(paint(n - 1, Red), Math.min(paint(n - 1, Green), paint(n - 1, Blue))));
    }
    private static int paint(int x, int color) {
        if (dp[color][x] == 0) {
            if (color == Red) {
                dp[Red][x] = Math.min(paint(x - 1, Green), paint(x - 1, Blue)) + cost[Red][x];
            } else if (color == Green) {
                dp[Green][x] = Math.min(paint(x - 1, Red), paint(x - 1, Blue)) + cost[Green][x];
            } else {
                dp[Blue][x] = Math.min(paint(x - 1, Green), paint(x - 1, Red)) + cost[Blue][x];
            }
        }
        return dp[color][x];
    }
}

