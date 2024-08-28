//백준 마인크래프트 자바
//브루트포스 + 백트래킹 구현문제!
//그냥 min값~max값 부터 쭉 확인해주면된다.

import java.io.*;
import java.util.*;

public class Main{
    private static int n, m, b;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }
        int time = Integer.MAX_VALUE;
        int height = -1;

        for (int i = min; i <= max; i++) {
            int second = 0;
            int inventory = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0 ; k < m; k++) {
                    int diff = map[j][k] - i;
                    if (diff > 0) {
                        second += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) {
                        second += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }
            if (inventory >= 0) {
                if (second <= time) {
                    time = second;
                    height = i;
                }
            }
        }
        System.out.println(time + " " + height);
    }


}
