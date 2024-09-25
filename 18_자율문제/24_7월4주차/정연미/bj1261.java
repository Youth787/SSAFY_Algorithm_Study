package Algo_스터디.July_4주차;

import java.io.*;
import java.util.*;

public class bj1261 {
    static int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int result = BFS(0,0);

        System.out.println(result);
    }
    public static int BFS(int i, int j){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visit = new boolean[N][M];
        visit[i][j] = true;
        q.add(new int[]{i,j,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==N-1 && curr[1]==M-1) return curr[2];

            for(int k=0; k<4; k++){
                int r = curr[0] + dir[k][0];
                int c = curr[1] + dir[k][1];

                if(r>=0 && c>=0 && r<N && c<M && !visit[r][c]){
                    if(map[r][c]==0) {
                        visit[r][c] = true;
                        q.add(new int[]{r, c, curr[2]});
                    }else if(map[r][c] ==1){
                        visit[r][c] = true;
                        q.add(new int[]{r,c,curr[2]+1});
                    }
                }
            }
        }
        return 0;

    }
}
