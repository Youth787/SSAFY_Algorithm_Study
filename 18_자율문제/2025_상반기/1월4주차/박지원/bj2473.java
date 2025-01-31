//백준 세 용액 자바
//투포인터

import java.io.*;
import java.util.*;

public class Main {
    private static int n, left, right, mid;
    private static int[] answer = new int[3];
    private static long[] arr;
    private static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            left = i;
            mid = i + 1;
            right = n - 1;
            while (mid < right) {
                long sum = arr[left] + arr[mid] + arr[right];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer[0] = left;
                    answer[1] = mid;
                    answer[2] = right;
                }
                if (sum == 0) break;
                else if (sum > 0) right--;
                else mid++;
            }
        }


        System.out.println(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
    }

}
