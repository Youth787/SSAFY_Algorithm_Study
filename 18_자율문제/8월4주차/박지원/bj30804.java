//백준 과일 탕후루 자바
//투포인터

import java.io.*;
import java.util.*;

public class Main{
    private static int n;
    private static int[] skewer, fruit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        skewer = new int[n];
        fruit = new int[10];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            skewer[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int idx = 0;
        while (right < n) {
            fruit[skewer[right++]]++;
            while (10 - count(fruit) > 2) {
                fruit[skewer[left++]]--;
            }
            answer = Math.max(answer, right - left);
        }
        System.out.println(answer);

    }
    private static int count(int[] arr) {
        int cnt = 0;
        for (int i: arr) {
            if (i == 0) cnt++;
        }
        return cnt;
    }

}
