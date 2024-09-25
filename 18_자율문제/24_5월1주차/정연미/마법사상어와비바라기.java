package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class cloud {
    int x;
    int y;
    public cloud(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 마법사상어와비바라기 {
    static int N,M;
    static int[][] move;
    static int[][] arr;
    static int d,s;
    static int[][] dir = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    //static int[][] pos;

    static int[][] fourpath = new int[][]{{1,1},{-1,-1},{1,-1},{-1,1}};
    static int result = 0;
    static Queue<cloud> q = new LinkedList<>();
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //pos = new int[][]{{N-2,0},{N-2,1},{N-1,0},{N-1,1}};
        q.add(new cloud(N-2,0));
        q.add(new cloud(N-2,1));
        q.add(new cloud(N-1,0));
        q.add(new cloud(N-1,1));

        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }
        // 입력받기 완료

        for(int i=0; i<M; i++){
            visit = new boolean[N][N];
            d = move[i][0];
            s = move[i][1];
            translate();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }
    public static void translate() {
        for (cloud current : q) {
            current.x = (current.x + (s % N) * dir[d - 1][0] + N) % N;
            current.y = (current.y + (s % N) * dir[d - 1][1] + N) % N;

            visit[current.x][current.y] = true;
            arr[current.x][current.y] += 1;
        }

        while (!q.isEmpty()) {
            cloud current = q.poll();
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int r = current.x + fourpath[k][0];
                int c = current.y + fourpath[k][1];
                if (r >= 0 && c >= 0 && r < N && c < N && arr[r][c] > 0) {
                    cnt += 1;
                }
            }
            arr[current.x][current.y] += cnt;
        }

        // Clouds regeneration
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    q.add(new cloud(i, j));
                }
            }
        }

    }

}
