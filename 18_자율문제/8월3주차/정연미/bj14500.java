package Algo_스터디.August_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14500 {
    static int[][] map;
    static boolean[][] visit;
    static int result =0;
    static int N, M;
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] =true;
                DFS(i,j,map[i][j],1);
                visit[i][j] = false;
            }
        }

        System.out.println(result);
    }
    public static void DFS(int i, int j ,int sum , int count){
        if(count==4) {
            result = Math.max(result,sum);
            return;
        }

        for(int k=0; k<4; k++){
            int r = i + dir[k][0];
            int c = j + dir[k][1];

            if(r<0 || c<0 || r>=N || c>=M) continue;

            if(!visit[r][c]){
                if(count==2){
                    visit[r][c] = true;
                    DFS(i,j,sum+map[r][c],count+1);
                    visit[r][c] =false;
                }

                visit[r][c] =true;
                DFS(r,c,sum+map[r][c],count+1);
                visit[r][c] =false;
            }
        }
    }
}
