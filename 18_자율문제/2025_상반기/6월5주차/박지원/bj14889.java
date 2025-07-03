// 백준 스타트와 링크 자바
// 조합, 구현 

import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[] picked;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        map = new int[n][n];
        StringTokenizer st;
        picked = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickHalf(0, 0);


        System.out.println(answer);
    }
    private static void pickHalf(int idx, int cnt) {
        if (cnt == n / 2) {
            getPower();
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                pickHalf(i + 1, cnt + 1);
                picked[i] = false;
            }
        }

    }
    private static void getPower() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (picked[i] && picked[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!picked[i] && !picked[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(link - start));
    }
}
