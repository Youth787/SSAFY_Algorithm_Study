//백준 행렬제곱 자바
//수학, 재귀함수

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static final int MOD = 1000;
    private static int[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        origin = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        int[][] result = pow(origin, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[][] pow(int[][] a, long exp) {
        if (exp == 1L) {
            return a;
        }
        int[][] ret = pow(a, exp/2);
        ret = multiply(ret, ret);
        if (exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }
        return ret;
    }
    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
