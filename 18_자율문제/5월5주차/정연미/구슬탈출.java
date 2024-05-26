package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class balls{
    int Rr;
    int Rc;
    int Br;
    int Bc;

    public balls(int Rr,int Rc, int Br, int Bc) {
        this.Rr = Rr;
        this.Rc = Rc;
        this.Br = Br;
        this.Bc = Bc;
    }
}

class personal{
    int r;
    int c;
    int cnt;
    public personal(int r,int c,int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class 구슬탈출2 {
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] arr;
    static boolean[][][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M][N][M];
        arr = new char[N][M];

        int Rr =0 ,Rc=0, Br=0, Bc=0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            arr[i] = input.toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'R') {
                    Rr = i;
                    Rc = j;
                }else if(arr[i][j] == 'B') {
                    Br = i;
                    Bc = j;
                }
            }
        }
        System.out.println(process(Rr,Rc,Br,Bc));
    }

    public static int process (int rdr , int rdc, int bdr, int bdc) {
        Queue<balls> q = new LinkedList<>();
        q.add(new balls(rdr, rdc, bdr, bdc));
        visit[rdr][rdc][bdr][bdc] = true;
        int time = 1;

        personal nRed =null;
        personal nBlue = null;

        while (!q.isEmpty()) {
            int size = q.size();
            
            while (size-- > 0) { // 2번씩 돌리기 위해서 
                balls current = q.poll();

                for (int k = 0; k < 4; k++) {
                    nRed = move(current.Rr, current.Rc, 0, k);
                    nBlue = move(current.Br, current.Bc, 0, k);

                    if(arr[nBlue.r][nBlue.c] == 'O') {
                        continue;
                    }else if(arr[nRed.r][nRed.c] == 'O') {
                        return 1;
                    }

                    if(nRed.r == nBlue.r && nRed.c == nBlue.c) {
                        if(nRed.cnt> nBlue.cnt){
                            nRed.r -= dir[k][0];
                            nRed.c -= dir[k][1];
                        }else{
                            nBlue.r -= dir[k][0];
                            nBlue.c -= dir[k][1];
                        }
                    }

                    if(visit[nRed.r][nRed.c][nBlue.r][nBlue.c]) continue;
                    visit[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;

                    q.add(new balls(nRed.r, nRed.c,nBlue.r,nBlue.c));
                }
            }
            if(++time >10) return 0;
        }
        return 0;
    }

    public static personal move(int r, int c, int dist, int k){
        int rr = r; int cc =c;
        while(arr[rr+dir[k][0]][cc+dir[k][1]]!='#' && arr[rr][cc] != 'O'){
            rr += dir[k][0];
            cc += dir[k][1];
            dist ++;
        }
        return new personal(rr,cc,dist);
    }
}
