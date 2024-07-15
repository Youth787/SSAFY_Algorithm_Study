//백준 N과 M2 자바
//ANSWER배열이 없어도 풀수있는문제.. 틀에 갇히지 말자고요

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] number;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        number = new int[n];
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            number[i - 1] = i;
        }

        solve(0, 0);
        System.out.println(sb);
    }
    private static void solve(int index, int count) {
        if (count == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(number[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (index >= n) return;
        visited[index] = true;
        solve(index + 1, count + 1);
        visited[index] = false;
        solve(index + 1, count);


    }


}

