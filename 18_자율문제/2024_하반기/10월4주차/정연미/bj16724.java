package GOLD;

import java.io.*;
import java.util.*;

public class bj16724 {
    static int safezone=0;
    static boolean[][] visit;
    static boolean[][] roundpoint;
    static char[][] arr;
    static int N, M;
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M];
        roundpoint = new boolean[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                char c = input.charAt(j);
                if(c=='U') arr[i][j] = 0;
                else if(c=='D') arr[i][j] = 1;
                else if(c=='R') arr[i][j] = 2;
                else arr[i][j] = 3;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                if(!visit[i][j]) DFS(i,j);
        }

        bw.write(Integer.toString(safezone));
        bw.flush();
        bw.close();
    }

    public static void DFS(int x, int y){
        visit[x][y] = true;

        char curr = arr[x][y];
        int r = x+dir[curr][0];
        int c = y+dir[curr][1];

        if(!visit[r][c]) DFS(r,c);
        else if(!roundpoint[r][c]) safezone++;
        roundpoint[x][y] = true;
    }
}
