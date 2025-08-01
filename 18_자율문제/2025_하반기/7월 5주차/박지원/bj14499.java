    import java.util.*;
    import java.io.*;

    public class Main {
        private static int n, m, x, y, k;
        private static int[][] map;
        private static int[] dice;
        //동 서 북 남
        private static int[] dx = {0, 0, -1, 1};
        private static int[] dy = {1, -1, 0, 0};
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            dice = new int[7];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                int num = Integer.parseInt(st.nextToken());
                move(num);
            }
        }
        private static void move(int d) {
            int mx = x + dx[d - 1];
            int my = y + dy[d - 1];
            if (mx < 0 || my < 0 || mx >= n ||  my >= m) return;
            roll(d, mx, my);
            x = mx;
            y = my;
        }

        //1 동 2 서 3 남 4 북
        //     1                1               1
        // 2   3   4       6    2    3     3    4   6
        //     5                5               5
        //     6                4               2
        private static void roll(int d, int mx, int my) {
            int temp = dice[3];
            switch (d) {
                case 1:
                    dice[3] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = temp;
                    break;
                case 2:
                    dice[3] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = temp;
                    break;
                case 3:
                    dice[3] = dice[1];
                    dice[1] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = temp;
                    break;
                case 4:
                    dice[3] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[1];
                    dice[1] = temp;
                    break;
            }

            if (map[mx][my] == 0) map[mx][my] = dice[6];
            else {
                dice[6] = map[mx][my];
                map[mx][my] = 0;
            }
            System.out.println(dice[3]);
        }



    }
