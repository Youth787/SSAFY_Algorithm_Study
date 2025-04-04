//백준 수열 자바
//슬라이딩윈도우, 누적합

import java.io.*;
import java.util.*;

//슬라이딩 윈도
public class Main {
    private static int n, k;
    private static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        degree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) degree[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += degree[i];
        }
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += degree[i];
            sum -= degree[i - k];
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }

}

// 누적합코드
// import java.io.*;
// import java.util.*;

// public class Main {
//     private static int n, k;
//     private static int[] degree,dp;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         k = Integer.parseInt(st.nextToken());
//         degree = new int[n + 1];
//         dp = new int[n + 1];
//         st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= n; i++) {
//             degree[i] = Integer.parseInt(st.nextToken());
//             dp[i] = dp[i - 1] + degree[i];
//         }
//         int result = cal();
//         System.out.println(result);
//     }
//     private static int cal() {
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i <= n - k; i++) {
//             int temp = dp[i + k] - dp[i];
//             max = Math.max(max, temp);
//         }
//         return max;
//     }

// }
