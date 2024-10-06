//백준 피보나치수 6 자바
//수학,, 행렬의 곱셈으로 규칙을 찾아 피보나치 만들기

import java.io.*;
import java.util.*;

public class Main{
    final static long MOD = 1000000007;
    private static long[][] origin = {{1, 1} , {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] A = {{1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());

        System.out.println(pow(A, n - 1)[0][0]);

    }
    private static long[][] pow (long[][] A, long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }

        long[][] ret = pow(A, exp / 2);
        ret = multiply(ret, ret);

        if (exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }
        return ret;
    }
    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
