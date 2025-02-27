//bfs 만 돌리면 됐네,, 흑흑

import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[n][n]; // 매일 방문 여부 초기화
            boolean moved = false;

            // 모든 위치에 대해 BFS 수행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            // 더 이상 이동할 인구가 없으면 종료
            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> unionList = new ArrayList<>(); // 연합 국가 좌표 저장
        queue.offer(new int[]{x, y});
        unionList.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        queue.offer(new int[]{nx, ny});
                        unionList.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                    }
                }
            }
        }

        // 연합이 1개(즉, 이동 불가)인 경우 false 반환
        if (unionList.size() == 1) return false;

        // 연합 국가들의 인구 분배
        int newPopulation = sum / unionList.size();
        for (int[] pos : unionList) {
            map[pos[0]][pos[1]] = newPopulation;
        }

        return true;
    }
}
