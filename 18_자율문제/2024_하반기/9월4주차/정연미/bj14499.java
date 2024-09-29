package GOLD;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class bj14499 {
    static int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    static int[] dice = new int[6];
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<k; i++){
            int input = Integer.parseInt(st.nextToken());
            int r = x+dir[input-1][0];
            int c = y+dir[input-1][1];
            if(r<0||r>=N||c<0||c>=M) continue;
            // 주사위 굴리기
            Dice(input);
            // 좌표 옮기기
            x = r;
            y = c;

            if(map[x][y]==0) map[x][y] = dice[1];
            else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }
    public static void Dice(int input){
        int up=0; int down=0; int right=0; int left =0; int north=0; int south=0;
        switch(input){
            case 1 : // 동
                up = dice[2]; down = dice[3]; right = dice[0]; left = dice[1];
                dice[0] = up; dice[1] = down; dice[2] = left; dice[3] = right;
                break;
            case 2 : // 서
                up = dice[3]; down = dice[2]; right = dice[1]; left = dice[0];
                dice[0] = up; dice[1] = down; dice[2] = left; dice[3] = right;
                break;
            case 3: // 북
                up = dice[5]; down = dice[4]; north = dice[0]; south=dice[1];
                dice[0] = up; dice[1] = down; dice[4] = north; dice[5] = south;
                break;
            case 4: // 남
                up = dice[4]; down = dice[5]; north = dice[1]; south=dice[0];
                dice[0] = up; dice[1] = down; dice[4] = north; dice[5] = south;
                break;
        }
    }
}
