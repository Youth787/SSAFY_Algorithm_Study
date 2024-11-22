//백준 부분합 자바
//투포인터 활용

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static long s;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        long currentSum = 0;

        while (end < n) {
            currentSum += arr[end++];
            while (currentSum >= s) {
                min = Math.min(min, end - start);
                currentSum -= arr[start++];
            }
        }
        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }

}
