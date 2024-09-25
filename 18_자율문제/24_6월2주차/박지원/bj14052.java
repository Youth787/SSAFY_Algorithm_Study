//백준 연구소 14052 자바
//dfs, bfs 전부 사용해야 하는 문제라서 너무 어려웠다.. 접근하기가 너무 어려웠음 그냥
//dfs로 벽 3개 랜덤하게 세워둔 뒤 bfs 전체 돌면서 바이러스 퍼트리고, safezone을 파악하고 최댓값을 갱신해주는 방법
//얕은복사를 하게되면 copymap을 건드려도 map이 변하기 떄문에 깊은복사가 필요했다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] copymap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxSafetyRoom = Integer.MIN_VALUE;
    static Queue<virus> q = new LinkedList<virus>();
    static class virus{
        int x;
        int y;
        public virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafetyRoom);
     }
     static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
     }
     static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.offer(new virus(i, j));
                }
            }
        }
        copymap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copymap[i] = map[i].clone();
        }
        while (!q.isEmpty()) {
            virus v = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copymap[nx][ny] == 0) {
                        copymap[nx][ny] = 2;
                        q.add(new virus(nx, ny));
                    }
                }
            }
        }
        funcSafeZone(copymap);
     }

     static void funcSafeZone(int[][] copy) {
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) safeZone++;
            }
        }
        maxSafetyRoom = Math.max(safeZone, maxSafetyRoom);
     }

}

