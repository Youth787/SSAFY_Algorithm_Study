package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pos{
    int i;
    int j;
    int cnt;
    int kused;
    public pos(int i, int j, int cnt, int kused){
        this.i = i;
        this.j = j;
        this.cnt= cnt;
        this.kused = kused;
    }
}

public class 말이되고픈원숭이 {
    static int[][] dir_m = new int[][]{{0,1},{0,-1},{1,0},{-1,0}}; // 원숭이 이동
    static int[][] dir_h = new int[][]{{-2,1},{2,1},{-2,-1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};// 말의 이동
    static int K,W,H;
    static int[][] arr;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        visit = new boolean[H][W][K+1];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력완료

        System.out.println(BFS());
    }
    public static int BFS(){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(0,0,0,0));

        while(!q.isEmpty()){
            pos current = q.poll();

            if(current.i==H-1 && current.j==W-1) return current.cnt;

            if(current.kused<K){ // 말이 움직이는 경우
                for(int i=0; i<8; i++){
                    int r = current.i+dir_h[i][0];
                    int c = current.j+dir_h[i][1];
                    if(r>=0&& c>=0 && r<H&& c<W && arr[r][c]==0 && !visit[r][c][current.kused+1]){
                        visit[r][c][current.kused+1] = true;
                        q.add(new pos(r,c,current.cnt+1,current.kused+1));
                    }
                }
            }

            for(int i=0; i<4; i++){ // 원숭이 이동
                int r = current.i+dir_m[i][0];
                int c = current.j+dir_m[i][1];
                if(r>=0&& c>=0 && r<H&& c<W && arr[r][c]==0 && !visit[r][c][current.kused]){
                    visit[r][c][current.kused] = true;
                    q.add(new pos(r,c,current.cnt+1, current.kused));
                }
            }
        }
        return -1;
    }
}
