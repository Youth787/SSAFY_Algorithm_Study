//백준 사전 자바
//DP, 조합 그냥 못풀겠음..포기..https://bono039.tistory.com/440

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static double k;
    private static double[][] dp = new double[101][101];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //a개수
        m = Integer.parseInt(st.nextToken()); //z개수
        k = Integer.parseInt(st.nextToken()); //k번째 문자 찾기
        if (check(n, m) < k) {
            System.out.println("-1");
        } else {
            makeS(n, m, k);
            System.out.println(sb.toString());
        }



    }
    private static double check(int a, int z) {
        if (a == 0 || z == 0) return 1;
        if (dp[a][z] != 0) return dp[a][z];

        return dp[a][z] = Double.min(check(a - 1, z) + check(a, z - 1), 1000000001);
    }
    private static void makeS(int a, int z, double k) {
        if (a == 0) {
            for (int i = 0; i < z; i++) {
                sb.append("z");
            }
            return;
        }
        if (z == 0) {
            for (int i = 0; i < a; i++) {
                sb.append("a");
            }
            return;
        }

        double check = check(a - 1, z);
        if (k > check) {
            sb.append("z");
            makeS(a, z - 1, k - check);
        } else {
            sb.append("a");
            makeS(a - 1, z, k);
        }
    }
}
