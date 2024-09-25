import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기_2583 {
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visit;
    static int[][] map;
    static int M,N;
    static int area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit =new boolean[M][N];
        List<Integer> area_arr = new ArrayList<>();

        int[][] point = new int[2][2];
        for(int t =0; t<K; t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    area =0;
                    BFS(i, j);
                    area_arr.add(area);
                    cnt++;
                }
            }
        }

        Collections.sort(area_arr);
        System.out.println(cnt);
        for(int a : area_arr) System.out.print(a + " ");
    }
    public static void BFS(int i , int j){
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(i,j));
        visit[i][j] = true;
        area++;

        while(!q.isEmpty()){
            Dot curr = q.poll();
            int r = curr.i;
            int c = curr.j;
            for(int k=0; k<4; k++) {
                int r2 = r+dir[k][0];
                int c2 = c+dir[k][1];
                if (r2 >= 0 && r2 < M && c2 >= 0 && c2 < N && !visit[r2][c2] && map[r2][c2]==0) {
                    q.add(new Dot(r2,c2));
                    visit[r2][c2] = true;
                    area++;
                }
            }
        }
    }
}
class Dot {
    int i;
    int j;
    public Dot (int i, int j){
        this.i= i;
        this.j= j;
    }
}
