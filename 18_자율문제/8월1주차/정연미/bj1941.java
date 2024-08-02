package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static int[] arrR = new int[25];
    static int[] arrC = new int[25];
    static int ans=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];

        for(int i=0; i<5; i++){
            String input = br.readLine();
            for(int j=0; j<5; j++)
                arr[i][j] = input.charAt(j);
        }

        for(int i=0; i<25; i++){
            arrR[i] = i/5;
            arrC[i] = i%5;
        }

        combination(new int[7], 0,0,0);

        System.out.println(ans);
    }
    public static void combination(int[] comb, int idx, int depth, int sevencnt){
        if(sevencnt == 7){
            bfs(comb);
            return;
        }

        if(depth ==25) return;

        comb[idx] = depth;
        combination(comb, idx+1, depth+1, sevencnt+1);
        combination(comb, idx, depth+1, sevencnt);
    }

    public static void bfs(int[] comb){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[7];

        q.add(comb[0]);
        visit[0] = true;
        int Scnt =0;
        int allcnt =1;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(arr[arrR[curr]][arrC[curr]]=='S') Scnt++;

            for(int k=0; k<4; k++){
                for(int pick=1; pick<7; pick++){
                    if(!visit[pick]&& arrR[curr] +dir[k][0] == arrR[comb[pick]] && arrC[curr]+dir[k][1]==arrC[comb[pick]]){
                        allcnt ++;
                        visit[pick] = true;
                        q.add(comb[pick]);
                    }
                }
            }
        }
        if(Scnt>=4 && allcnt==7) ans++;
    }
}
