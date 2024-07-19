package Algo_스터디.July_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj14502 {
    static int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static int N, M;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 벽을 세우자
        DFS(0);

        System.out.println(result);
    }

    public static void DFS(int wall){
        if(wall==3){
            // 바이러스 전파
            BFS();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    DFS(wall+1);
                    map[i][j] =0;
                }
            }
        }

    }

    public static void BFS(){
        int copyMap[][] = new int[N][M];
        for(int t=0; t<N; t++){
            copyMap[t] = map[t].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                if(map[i][j]==2)
                    q.add(new int[]{i,j});
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int k=0; k<4; k++){
                int r = curr[0] + dir[k][0];
                int c = curr[1] + dir[k][1];

                if(r>=0 && r<N && c>=0 && c<M && copyMap[r][c]==0){
                    q.add(new int[]{r,c});
                    copyMap[r][c] = 2;
                }
            }
        }

        safezone(copyMap); // 안정영역 확인
    }

    public static void safezone(int[][] copymap){
        int cnt =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                if(copymap[i][j]==0) cnt++;
        }
        result = Math.max(result,cnt);
    }
}
