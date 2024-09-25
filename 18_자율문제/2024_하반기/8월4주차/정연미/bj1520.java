package Algo_스터디.August_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1520 {
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M ;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][M];
        for(int[] a : dp) Arrays.fill(a,-1);
        System.out.println(DFS(0,0));
    }
    public static int DFS(int i, int j ) {
       if(i==N-1 && j ==M-1) return 1;
       if(dp[i][j]!=-1) return dp[i][j];
       dp[i][j] = 0;
       for(int k=0; k<4; k++) {
           int r = i + dir[k][0];
           int c = j + dir[k][1];
           if(r<0||c<0||r>=N||c>=M) continue;
           if(arr[i][j]>arr[r][c]){
               dp[i][j] += DFS(r,c);
           }
       }
       return dp[i][j];
    }
}
