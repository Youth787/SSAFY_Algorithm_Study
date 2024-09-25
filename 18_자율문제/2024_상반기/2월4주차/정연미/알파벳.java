package ALGO_STUDY.Fev_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳 {
    static int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] arr;
    static int N, M;
    static int ans =0;
    static boolean[] visit = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'A';
            }
        }// 입력받기 완료

        if(N==1&& M==1){
            ans =1;
        }else {
            check(0, 0, 0);
        }

        System.out.println(ans);
    }

    public static void check(int r, int c, int cnt){
        if(visit[arr[r][c]]){
            ans = Math.max(ans,cnt);
            return;
        }

        visit[arr[r][c]]= true;
        for(int k=0; k<4; k++){
            int ar = r+dir[k][0];
            int ac = c+dir[k][1];
            if(ar>=0&&ac>=0&& ar<N&&ac<M){
                check(ar,ac,cnt+1);
            }
        }
        visit[arr[r][c]] = false;
    }

}
