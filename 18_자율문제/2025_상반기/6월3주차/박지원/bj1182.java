//백준 부분수열의 합 자바
//dfs

import java.io.*;
import java.util.*;

public class Main {
    private static int n, s, answer;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (s == 0) System.out.println(answer - 1);
        else System.out.println(answer);
    }
    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) answer++;
            return;
        }
        
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
