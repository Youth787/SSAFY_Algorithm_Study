import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[H][W];
            boolean[][] visit = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j) == '#';
                }
            }

            sb.append(bfs(H, W, map, visit)).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static int bfs(int H, int W, boolean[][] map, boolean[][] visit) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] && !visit[i][j]) {
                    result++;
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];

                            if (nr < 0 || nr >= H || nc < 0 || nc >= W || !map[nr][nc] || visit[nr][nc]) continue;
                            visit[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return result;
    }

}
