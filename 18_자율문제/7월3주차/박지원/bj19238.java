//백준 스타트택시 자바
// BFS, PQ의 합작.. 어렵다 ㅎ그흑.. 다시풀어보기
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int startX, startY, nowGuest;
    private static class Position implements Comparable<Position> {
        int x;
        int y;
        int fuels;

        public Position(int x, int y, int fuels) {
            this.x = x;
            this.y = y;
            this.fuels = fuels;
        }

        @Override
        public int compareTo(Position p) {
            if (this.fuels == p.fuels) {
                if (this.x == p.x) {
                    return this.y - p.y;
                } else {
                    return this.x - p.x;
                }
            }
            return this.fuels - p.fuels;
        }
    }
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static ArrayList<Position> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 2; i < m + 2; i++) {
            st = new StringTokenizer(br.readLine());
            int guestX = Integer.parseInt(st.nextToken()) - 1;
            int guestY = Integer.parseInt(st.nextToken()) - 1;
            int destinationX = Integer.parseInt(st.nextToken()) - 1;
            int destinationY = Integer.parseInt(st.nextToken()) - 1;
            map[guestX][guestY] = i;
            list.add(new Position(destinationX, destinationY, 0));
        }
        //입력 끝
        int count = 0;
        while (count < m) {
            int temp = findGuest(n, map);
            if (fuel - temp <= 0 || temp == -1) {
                break;
            }
            int temp1 = goDestination(n, map);
            if (fuel - (temp + temp1) < 0 || temp1 == -1) {
                break;
            } else {
                fuel += temp1 - temp;
            }
            count++;
        }
        if (count != m) fuel = -1;
        System.out.println(fuel);
    }
    public static int findGuest(int n, int[][] map) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        pq.add(new Position(startX, startY, 0));
        visited[startX][startY] = true;
        while (!pq.isEmpty()) {
            Position now = pq.poll();
            if (map[now.x][now.y] > 1) {
                nowGuest = map[now.x][now.y];
                startX = now.x;
                startY = now.y;
                map[startX][startY] = 0;
                return now.fuels;
            }
            for (int i = 0; i < 4; i++) {
                int dr = now.x + dx[i];
                int dc = now.y + dy[i];
                if (isMap(dr, dc, n) && !visited[dr][dc] && map[dr][dc] != 1) {
                    visited[dr][dc] = true;
                    pq.add(new Position(dr, dc, now.fuels + 1));
                }
            }
        }
        return -1;
    }
    public static boolean isMap(int x, int y, int n) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }
    public static int goDestination(int n, int[][] map) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        pq.add(new Position(startX, startY, 0));
        visited[startX][startY] = true;
        int destinationX = list.get(nowGuest - 2).x;
        int destinationY = list.get(nowGuest - 2).y;
        while (!pq.isEmpty()) {
            Position now = pq.poll();
            if (now.x == destinationX && now.y == destinationY) {
                startX = destinationX;
                startY = destinationY;
                return now.fuels;
            }
            for (int i = 0; i < 4; i++) {
                int dr = now.x + dx[i];
                int dc = now.y + dy[i];
                if (isMap(dr, dc, n) && !visited[dr][dc] && map[dr][dc] != 1) {
                    visited[dr][dc] = true;
                    pq.add(new Position(dr, dc, now.fuels + 1));
                }
            }

        }
        return -1;
    }
}

// 지금 있는 위치에서 가장 가까운 손님 찾기 ->  findGuest함수: 만약 가까운 손님이 여러명이면 가장 행열 낮은순서로
// findGuest는 BFS를 활용하여 손님을 찾는다.
// 손님을 찾았으면, 그 손님의 목적지까지 가며 fuel줄이기,만약 도착 못했는데 fuel이 0이면 -1출력후 멈추기
// 도착했으면 다음 손님이 있는지 확인 후 있으면 연료 충전(고객->목적지 2배), 없으면 남은 연료 출력

