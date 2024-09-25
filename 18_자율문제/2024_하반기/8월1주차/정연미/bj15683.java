package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15683 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int[][][] mode = {{{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}};
    public static ArrayList<Node> cctv;
    public static class Node {
        int x;
        int y;
        int type;
        public Node(int x, int y, int type) {
            this.x= x;
            this.y= y;
            this.type = type;
        }
    }
    public static int n, m, ans;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cctv = new ArrayList<>();
        int zero_cnt = 0;
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                } else if(map[i][j] == 0) zero_cnt++;
            }
        }

        ans = zero_cnt;
        combination(0, map);
        System.out.println(ans);
    }

    public static void combination(int depth, int[][] map) {
        if(depth == cctv.size()) {
            int cnt = check(map);
            ans = Math.min(ans, cnt);
            return;
        }

        int cctv_type = cctv.get(depth).type-1;
        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;

        for(int i=0;i<mode[cctv_type].length;i++) {
            int[][] map_copy = new int[n][m];
            for(int k=0;k<n;k++) {
                map_copy[k] = map[k].clone();
            }

            for(int j=0;j<mode[cctv_type][i].length;j++){
                int dir = mode[cctv_type][i][j];

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (true) {
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 6)
                        break;

                    map_copy[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            combination(depth+1, map_copy);
        }
    }

    public static int check(int[][] map) {
        int cnt = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(map[i][j] == 0)
                    cnt++;
        return cnt;
    }
}
