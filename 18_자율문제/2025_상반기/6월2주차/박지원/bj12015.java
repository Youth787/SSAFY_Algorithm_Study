//백준 가장 긴 증가하는 부분 수열 2 자바
//이분탐색 , LIS

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] arr, LIS;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        LIS = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        LIS[0] = arr[0];
        int lengthLIS = 1;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if (LIS[lengthLIS - 1] < key) {
                lengthLIS++;
                LIS[lengthLIS - 1] = key;
            } else {
                int low = 0;
                int high = lengthLIS;
                while (low < high) {
                    int mid = (low + high) / 2;

                    if (LIS[mid] < key) {
                        low = mid + 1;
                    } else high = mid;
                }
                LIS[low] = key;
            }
        }
        System.out.println(lengthLIS);
    }

}
