//백준 팰린드롬? 자바
//구현,, 근데 DP로 다시 풀어야할듯

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int answer = isPalindrome(s - 1, e - 1);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static int isPalindrome(int s, int e) {
        while (s <= e) {
            if (number[s] == number[e]) {
                s++;
                e--;
            } else return 0;
        }

        return 1;
    }
}
