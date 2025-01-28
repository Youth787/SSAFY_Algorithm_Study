//백준 dance dance revolution 자바
//DP 3차원 참고 https://loosie.tistory.com/257

import java.util.*;
import java.io.*;

public class Main {
    private static int[] move;
    private static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] steps = br.readLine().split(" ");
        move = new int[steps.length - 1];
        for (int i = 0; i < steps.length - 1; i++) {
            move[i] = Integer.parseInt(steps[i]);
        }
        dp = new int[5][5][steps.length];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0, 0, 0));

    }
    static int energy(int pos, int des) {
        int num = Math.abs(pos - des);
        if (pos == 0) return 2;
        else if (num == 0) return 1;
        else if (num == 1 || num == 3) return 3;
        else return 4;
    }
    static int solve(int left, int right, int cnt) {
        if (cnt == move.length) return 0;
        if (dp[left][right][cnt] != -1) return dp[left][right][cnt];
        dp[left][right][cnt] = Math.min(solve(move[cnt], right, cnt + 1) + energy(left, move[cnt]), solve(left, move[cnt], cnt + 1) + energy(right, move[cnt]));
        return dp[left][right][cnt];
    }
}
