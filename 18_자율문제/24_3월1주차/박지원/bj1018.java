import java.io.*;
import java.util.*;

//체스판 다시 칠하기
public class Main {

    private static int n, m;
    private static char[][] map;
    private static char[][] whiteboard, blackboard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        map = new char[n][m];
        whiteboard = new char[8][8];
        blackboard = new char[8][8];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 != j % 2) {
                    blackboard[i][j] = 'W';
                    whiteboard[i][j] = 'B';
                } else {
                    blackboard[i][j] = 'B';
                    whiteboard[i][j] = 'W';
                }
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, Math.min(countBlack(i, j), countWhite(i, j)));
            }
        }

        System.out.println(answer);


    }
    private static int countBlack(int x, int y) {
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != blackboard[i - x][j - y]) count++;
            }
        }
        return count;
    }

    private static int countWhite(int x, int y) {
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != whiteboard[i - x][j - y]) count++;
            }
        }
        return count;
    }
}
