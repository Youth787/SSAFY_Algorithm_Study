import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());   // 시작 방향
            int g = Integer.parseInt(st.nextToken());   // 세대

            dragonCurve(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> d_list = new ArrayList<>();
        d_list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = d_list.size() - 1; j >= 0; j--) {
                d_list.add((d_list.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (Integer direction : d_list) {
            x += dx[direction];
            y += dy[direction];
            map[y][x] = true;
        }
    }
}
