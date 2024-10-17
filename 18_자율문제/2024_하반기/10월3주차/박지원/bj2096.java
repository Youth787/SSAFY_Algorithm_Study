//자바 내려가기 백준
//DP

import java.io.*;
import java.util.*;

public class Main{
    private static int n, min, max;
    private static int[][] minDp, maxDp, map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        minDp = new int[n][3];
        maxDp = new int[n][3];
        map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
            map[i][2] = c;
        }
        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];
        maxDp[0][0] = map[0][0];
        maxDp[0][1] = map[0][1];
        maxDp[0][2] = map[0][2];
        for (int i = 1; i < n; i++) {
            minDp[i][0] = map[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = map[i][1] + Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][2], minDp[i - 1][1]));
            minDp[i][2] = map[i][2] + Math.min(minDp[i - 1][2], minDp[i - 1][1]);
            maxDp[i][0] = map[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = map[i][1] + Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][2], maxDp[i - 1][1]));
            maxDp[i][2] = map[i][2] + Math.max(maxDp[i - 1][2], maxDp[i - 1][1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2])));
        sb.append(" ");
        sb.append(Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2])));
        System.out.println(sb);
    }

}
