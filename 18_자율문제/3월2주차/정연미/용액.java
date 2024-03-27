package ALGO_STUDY.Mar_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int result =  Integer.MAX_VALUE;
        int[] ans = new int[2];

        while(start < end) {
            int sum = arr[start] + arr[end];
            if (result > Math.abs(sum)) {
                result = Math.abs(sum);
                ans[0] = arr[start];
                ans[1] = arr[end];
                if (sum == 0) break;
            }
            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
            System.out.println(ans[0]+" "+ans[1]);
    }
}
