//백준 용액 자바
//투포인터(이분탐색)

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] arr, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        while(l < r) {
            int sum = Math.abs(arr[l] + arr[r]);
            if (sum < min) {
                min = sum;
                answer[0] = arr[l];
                answer[1] = arr[r];
            }
            
            if (arr[l] + arr[r] >= 0) {
                r--;
            } else l++;
        }
        for (int a: answer)
            System.out.println(a + " ");
    }

}
