//백준 태상이의 훈련소생활 자바 누적합
//2024 현대오토에버 문제랑 상당히 비슷한문제!!
//문제에 나와있는 n, m의 범위가 2중 포문을 돌리면 바로 터지는 문제기 때문에 그부분에 유의하여 풀이해야함

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] height = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sum[a - 1] += k;
            sum[b] -= k;
        }
        for (int i = 0; i < n; i++) {
            sum[i + 1] += sum[i];
            sb.append(height[i + 1] + sum[i]).append(" ");
        }
        System.out.println(sb);
    }

}
