package Algo_스터디.Mar_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스도쿠 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i=0; i<9; i++){
            String input = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        playSdoku();
    }
    public static void playSdoku(){
        int[] idx = findzeroidx();

        if(idx[0]==-1){
            printSdoku();
            System.exit(0);
        }

        for(int i=1; i<=9; i++){
            if(isValidPosition(idx,i)){
                map[idx[0]][idx[1]] = i;
                playSdoku();
                map[idx[0]][idx[1]] = 0;
            }
        }
    }
    public static int[] findzeroidx(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(map[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void printSdoku(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean isValidPosition(int[] idx, int i){
        int r = idx[0];
        int c = idx[1];
        for(int k=0; k<9; k++){
            if(map[r][k]==i || map[k][c]==i) return false;
        }

        int sr = (r/3)*3;
        int sc = (c/3)*3;
        for(int k=sr; k<sr+3; k++){
            for(int j=sc; j<sc+3; j++){
                if(map[k][j]==i) return false;
            }
        }

        return true;
    }
}
