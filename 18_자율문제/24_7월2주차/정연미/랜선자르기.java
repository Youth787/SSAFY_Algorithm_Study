package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long left = 1;
        long right = 0;

        for (int i = 0; i < K; i++) {
            int length = Integer.parseInt(br.readLine());
            arr[i] = length;
            right = Math.max(right, length);
        }

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int length : arr) count += length / mid;
            if (count < N) right = mid-1;
            else left = mid + 1;
        }
        System.out.println(right);
    }
}
