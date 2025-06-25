//백준 스도쿠 자바
//DFS, 구현, 백트래킹

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        StringTokenizer st;
        n = temp.length;
        map = new int[n][n];
        for (int i = 0; i < n; i++) map[0][i] = Integer.parseInt(temp[i]);
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);




    }
    private static void sudoku(int x, int y) {
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }

        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(x, y, i)) {
                    map[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }

        sudoku(x, y + 1);
    }

    private static boolean possibility(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == value) return false;
        }

        int r = 3 * (x / 3);
        int c = 3 * (y / 3);
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }

        return true;
    }
}
