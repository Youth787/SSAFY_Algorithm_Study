package Algo_스터디.August_2주차;

import java.io.IOException;
import java.io.*;
import java.util.*;


//미완 
public class bj17135 {
    static int N, M, D;
    static int max = 0;
    static int[][] arr;
    static List<int[]> anemy = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a==1) anemy.add(new int[]{i,j});
                arr[i][j] = a;

            }
        }

        pick(0,0, new int[3]);
        System.out.println(max);
    }
    public static void pick(int idx, int depth,int[] pickarr){
        if(idx == 3){
            max = Math.max(max,game(pickarr));
            return;
        }

        if(depth ==M) return;

        pickarr[idx] = depth;
        pick(idx+1, depth+1,pickarr);
        pick(idx,depth+1,pickarr);
    }

    public static int game(int[] pickarr){
        int count =0;
        int[][] status = new int[N][M];

        for(int line =N; line>0; line--){
            for(int pick : pickarr){
                for(int d=1; d<=D; d++){
                    int cnt = attack(status,d,line,pick);
                    if(cnt<0) continue;
                    count+=cnt;
                    break;
                }
            }
        }

        return count;
    }

    public static int attack(int[][] status, int d, int line, int pick){
        for(int i=0; i<anemy.size(); i++){
            int[] anemypick = anemy.get(i);
            int distance = Math.abs(line-anemypick[0]) + Math.abs(pick-anemypick[1]);
            if(distance<=d) {
                if(status[anemypick[0]][anemypick[1]]==0) {
                    status[anemypick[0]][anemypick[1]] =line;
                    return 1;
                }else if(status[anemypick[0]][anemypick[1]]==line) return 0;
            }
        }
        return -1;
    }
}
