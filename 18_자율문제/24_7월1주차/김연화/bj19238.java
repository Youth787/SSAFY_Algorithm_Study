import java.io.*;
import java.util.*;

public class Main {

    static int N, M, fuel;
    static int count = 0;

    static int[][] map;
    static boolean[][] visited;
    static Position taxi;
    static Position[] destination;
    static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    static StringTokenizer st;

    static class Position implements Comparable<Position> {
        int r, c;

        public Position(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Position o) {
            if (this.r == o.r) {
                return this.c - o.c;
            }
            return this.r - o.r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        destination = new Position[M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j] == 1 ? -1 : map[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = i;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            destination[i] = new Position(r, c);
        }

        for (int i = 0; i < M; i++) {
            int passenger = findPassenger(taxi);
            fuel -= count;
            if (passenger == -1 ||fuel <= 0) {
                System.out.println(-1);
                return;
            }
            int use = goDest(taxi, passenger);
            if (fuel < use || use == -1) {
                System.out.println(-1);
                return;
            }

            fuel += use;

            map[taxi.r][taxi.c] = 0;
            taxi = destination[passenger];
        }
        System.out.println(fuel);
    }

    static int findPassenger(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], false);
        }
        count = 0;

        queue.offer(pos);
        if (map[pos.r][pos.c] > 0) {
            return map[pos.r][pos.c];
        }

        int size = 0;
        while (!queue.isEmpty()) {
            count++;
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];

                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= 0) {
                        if (map[nr][nc] > 0) {
                            pq.offer(new Position(nr,nc));
                        }
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            if(!pq.isEmpty()) {
                taxi = pq.poll();
                return map[taxi.r][taxi.c];
            }
        }
        return -1;
    }

    static int goDest(Position taxi, int passNo) {
        Queue<Position> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], false);
        }

        queue.offer(taxi);
        visited[taxi.r][taxi.c] = true;

        int size = 0;
        count = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();

                if (temp.r == destination[passNo].r && temp.c == destination[passNo].c) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + deltas[i][0];
                    int nc = temp.c + deltas[i][1];

                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= 0) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 1 && c >= 1 && r <= N && c <= N;
    }
}
