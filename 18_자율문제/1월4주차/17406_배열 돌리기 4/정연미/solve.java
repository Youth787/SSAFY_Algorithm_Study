package Algo_스터디.Jan_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://koguri.tistory.com/97

public class 배열돌리기4_1740 {
    static int N,M,K,min;
    static boolean[] visit;
    static int[] result;
    static int[][] circle;
    static int[][] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr= new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        circle = new int[K][3];
        for(int k = 0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            circle[k][0] = Integer.parseInt(st.nextToken()) - 1;
            circle[k][1] = Integer.parseInt(st.nextToken()) - 1;
            circle[k][2] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[K];
        result = new int[K];
        min =Integer.MAX_VALUE;
        pnp(0);
        System.out.println(min);
    }
    public static void pnp(int idx){
        if(idx==K){
            round();

            for(int i=0; i<N; i++) {
                int sum =0;
                for(int j=0; j<M; j++) sum += tmp[i][j];
                min = Math.min(min,sum);
            }
            return;
        }

        for(int i=0; i<K; i++){
            if(visit[i]) continue;
            visit[i] = true;
            result[idx] = i;
            pnp(idx+1);
            visit[i] = false;
        }
    }

    public static int[][] copyMap() {
        tmp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static void round(){
        tmp = copyMap();
        // 회전시키는 메서드
        for(int i=0; i<K; i++){
            int r= circle[result[i]][0];
            int c = circle[result[i]][1];
            int S = circle[result[i]][2];

            for(int s=1; s<=S; s++){
                int righttop = tmp[r-s][c+s];
                for(int j=c+s; j>c-s; j--){
                    tmp[r-s][j] = tmp[r-s][j-1];
                }

                int rightbottom = tmp[r+s][c+s];
                for(int j=r+s; j>r-s; j--){
                    tmp[j][c+s] = tmp[j-1][c+s];
                }
                tmp[r-s+1][c+s] = righttop;
                int leftbottom = tmp[r+s][c-s];
                for(int j=c-s; j<c+s; j++){
                    tmp[r+s][j] = tmp[r+s][j+1];
                }
                tmp[r+s][c+s-1] = rightbottom;

                for(int j=r-s; j<r+s; j++){
                    tmp[j][c-s] = tmp[j+1][c-s];
                }
                tmp[r+s-1][c-s] = leftbottom;
            }
        }
    }
}
