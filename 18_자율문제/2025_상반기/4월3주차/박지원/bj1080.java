//백준 행렬 자바
//그리디

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j) - '0';
            }
        }
        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0 ; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    answer++;
                    flip(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    private static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                a[i][j] *= -1;
                a[i][j]++;
            }
        }


    }

}

