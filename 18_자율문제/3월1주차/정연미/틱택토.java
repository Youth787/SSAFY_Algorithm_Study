package ALGO_STUDY.Mar_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            int cntO = 0;
            int cntX = 0;
            arr = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = s.charAt(3 * i + j);
                    if (arr[i][j] == 'O') cntO++;
                    else if (arr[i][j] == 'X') cntX++;
                }
            }// 입력받기 완료

            // 1. 판에 말이 전부 놓인경우 ( x의 개수가 1개 더 많아야한다.)
            if (cntO + cntX == 9 && cntX - cntO == 1) {
                if (Check('X') && Check('O')) sb.append("invalid\n");
                else if (Check('O')) sb.append("invalid\n");
                else sb.append("valid\n");
            } else { // 2. 빈칸이 있는 경우
                if (Check('X') && Check('O')) sb.append("invalid\n");
                else if (Check('O') && cntX == cntO) sb.append("valid\n");
                else if (Check('X') && cntX - cntO == 1) sb.append("valid\n");
                else sb.append("invalid\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean Check(char tiktakto) {
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == tiktakto) cnt++;
            }
            if (cnt == 3) return true;
        }
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[j][i] == tiktakto) cnt++;
            }
            if (cnt == 3) return true;
        }
        if (arr[0][0] == tiktakto && arr[1][1] == tiktakto
                && arr[2][2] == tiktakto) return true;
        if (arr[0][2] == tiktakto && arr[1][1] == tiktakto
                && arr[2][0] == tiktakto) return true;
        return false;
    }
}