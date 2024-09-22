package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://pangtrue.tistory.com/282

public class bj15684 {
    static int answer;
    static boolean success = false;
    static int[][] ladder;
    static int N, M, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            ladder[left-1][right-1] = 1;
            ladder[left-1][right] = 2;
        }

        for(int i=0; i<=3; i++){
            answer = i;
            dfs(0,0,0);
            if(success) break;
        }

        System.out.println(success? answer:-1);
    }
    public static void dfs(int h, int w, int addladdernum){
        if(success) return;
        if(answer==addladdernum){
            if(check()) success = true;
            return;
        }

        for(int i=h; i<H; i++) {
            for (int j = w; j < N - 1; j++) {
                if (ladder[i][j] == 0 && ladder[i][j+1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;

                    dfs(0,0,addladdernum+1);

                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }

    public static boolean check(){
        for(int i=0; i<N; i++){
            int res = i;
            int n =0;
            while(n<H){
                if (ladder[n][res]==1) res++;
                else if(ladder[n][res]==2) res--;
                n++;
            }
            if(res!=i) return false;
        }
        return true;
    }
}
