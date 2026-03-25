import java.util.*;
import java.io.*;

public class bj14002 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n]; // arr[i]의 증가하는 부분 수열의 크기를 저장

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int lis = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lis + "\n");
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lis) {
                s.push(arr[i]);
                lis--;
            }
        }
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }


}
