package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class bj16234 {
    static int N, L, R;
    static int[][] board;
    static boolean[][] visit;
    static List<Dot> list;
    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(move());
    }
    public static int move(){
        int result =0;
        while(true){
            boolean isMove = false;
            visit = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j]){
                        int sum = bfs(i,j);
                        if(list.size()>1){
                            changepopulation(sum);
                            isMove=true;
                        }
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
    }

    public static int bfs(int i, int j){
        Queue<Dot> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new Dot(i,j));
        list.add(new Dot(i,j));
        visit[i][j] = true;

        int sum = board[i][j];
        while(!q.isEmpty()){
            Dot current = q.poll();
            int r = current.x;
            int c = current.y;

            for(int k=0; k<4;k++){
                int rr = r+dir[k][0];
                int cc = c+dir[k][1];
                if(rr>=0 && cc>=0 && rr<N &&cc<N &&!visit[rr][cc]){
                    int diff = Math.abs(board[rr][cc] - board[r][c]);
                    if(diff>=L&&diff<=R){
                        q.offer(new Dot(rr,cc));
                        visit[rr][cc] = true;
                        list.add(new Dot(rr,cc));
                        sum+=board[rr][cc];
                    }
                }
            }
        }
        return sum;
    }

    public static void changepopulation(int sum){
        int avg = sum/list.size();
        for(Dot n : list) board[n.x][n.y] = avg;
    }

    public static class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
