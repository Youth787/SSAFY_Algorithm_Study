package Algo_스터디.July_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj6593 {
    static int[][] dir = new int[][]{{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        while(L!=0){
            boolean flag = false;
            char[][][] building = new char[L][R][C];
            boolean[][][] visit = new boolean[L][R][C];

            int[] start = new int[3];
            int[] end = new int[3];

            for(int i=0;i<L; i++){
                for(int j=0; j<R; j++){
                    String input = br.readLine();
                    for(int k=0; k<C; k++) {
                        char letter = input.charAt(k);
                        if(letter =='S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }else if(letter =='E'){
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                        building[i][j][k] = letter;
                    }
                }
                String blank = br.readLine();
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[3]-b[3]);
            q.add(new int[]{start[0],start[1],start[2],0});
            visit[start[0]][start[1]][start[2]] = true;

            while(!q.isEmpty()){
                int[] curr = q.poll();

                if(curr[0]==end[0]&& curr[1]==end[1] && curr[2] ==end[2]) {
                    sb.append("Escaped in ").append(curr[3]).append(" minute(s).").append("\n");
                    flag= true;
                    break;
                }

                for(int k=0; k<6; k++){
                    int l = curr[0] + dir[k][0];
                    int r = curr[1] + dir[k][1];
                    int c = curr[2] + dir[k][2];

                    if(r>=0 && c>=0 && l>=0 && r<R && c<C && l<L && !visit[l][r][c]&& building[l][r][c]!='#'){
                        visit[l][r][c] = true;
                        q.add(new int[]{l,r,c,curr[3]+1});
                    }
                }
            }

            if(!flag){
                sb.append("Trapped!").append("\n");
            }

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb.toString());
    }
}
