import java.util.*;
import java.io.*;

public class bj3055 {

    static int r, c;
    static char[][] map;
    static int[][] count;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> water, q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        count = new int[r][c];
        water = new LinkedList<>();
        q = new LinkedList<>();
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new int[]{i, j, 0});
                } else if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                }
            }
        }
        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            //물 퍼지기
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] t = water.poll();
                int x = t[0];
                int y = t[1];
                for (int k = 0; k < 4; k++) {
                    int mx = x + dx[k];
                    int my = y + dy[k];
                    if (mx < 0 || my < 0 || mx >= r || my >= c) continue;
                    if (map[mx][my] == '.') {
                        map[mx][my] = '*';
                        water.add(new int[] {mx, my});
                    }
                }
            }
            //고슴도치 이동
            len = q.size();
            for (int i = 0; i < len; i++) {
                int[] now = q.poll();
                for (int k = 0; k < 4; k++) {
                    int mx = now[0] + dx[k];
                    int my = now[1] + dy[k];
                    if (mx < 0 || my < 0 || mx >= r || my >= c) continue;
                    if (map[mx][my] == 'D') {
                        answer = Math.min(answer, now[2] + 1);
                        return;
                    } else if (map[mx][my] == '.') {
                        map[mx][my] = 'S';
                        q.add(new int[]{mx, my, now[2] + 1});
                    }
                }
            }


        }

    }

}