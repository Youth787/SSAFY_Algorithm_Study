package Algo_스터디.Mar_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 단지번호붙이기 {
    static int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;
    static int N, cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        visit = new boolean[N][N];
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j]==1) {
                    cnt = 1;
                    visit[i][j] = true;
                    DFS(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int r = x+dir[i][0];
            int c = y+dir[i][1];
            if(r>=0 && c>=0 && r<N && c<N && !visit[r][c] && map[r][c]==1){
                visit[r][c]= true;
                cnt++;
                DFS(r,c);
            }
        }

    }
}
