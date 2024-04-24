package GOLD;// 최단경로?=> BFS OR 다익스트라

// 벽인 경우 => 1) 부순적이 있다? 못부순다. 2) 부순적이 없다. 부순다.
// 벽이 아닌 경우 => 1) 부순적이 있든 없든 간다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class idxx{
    int x;
    int y;
    int cnt;
    int wallbreak;
    public idxx(int x, int y, int cnt, int wallbreak){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        this.wallbreak=wallbreak;
    }
}

public class 벽부수고이동하기2 {
    static int N, M,K;
    static int[][] arr;
    static boolean[][][] visit;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j)-'0';
            }
        } // 입력받기 완료

        System.out.println(run());
    }

    public static int run(){
        Queue<idxx> q = new LinkedList<>();
        q.offer(new idxx(0,0,1,0));

        while(!q.isEmpty()){
            idxx current = q.poll();
            int x = current.x;
            int y = current.y;
            int cnt = current.cnt;
            int wallbreak = current.wallbreak;

            if (x == N - 1 && y == M - 1) {
                return cnt;
            }

            for(int k=0; k<4; k++){
                int r = x+dir[k][0];
                int c = y+dir[k][1];

                if(r >= 0 && c >= 0 && r < N && c < M){
                    if(arr[r][c]==0){
                        if(!visit[r][c][wallbreak]) {
                            q.add(new idxx(r, c, cnt + 1, wallbreak));
                            visit[r][c][wallbreak] = true;
                        }
                    }else if(arr[r][c]==1){
                        if(wallbreak<K && !visit[r][c][wallbreak+1]){
                            q.add(new idxx(r,c,cnt+1,wallbreak+1));
                            visit[r][c][wallbreak+1]= true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
