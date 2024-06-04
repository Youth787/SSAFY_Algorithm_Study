package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class ball {
    int r;
    int c;
    int cnt;
    public ball(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Balls {
    int Rr;
    int Rc;
    int Br;
    int Bc;
    public Balls(int Rr, int Rc, int Br, int Bc) {
        this.Rr = Rr;
        this.Rc = Rc;
        this.Br = Br;
        this.Bc = Bc;
    }
}
public class 구슬탈출 {
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] arr;
    static boolean[][][][] visit;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M][N][M];

        int Rr =0 ,Rc=0, Br=0, Bc=0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr[i] = input.toCharArray();
            for (int j = 0; j < M; j++) {
                if(arr[i][j]=='R') {
                    Rr = i;
                    Rc = j;
                }else if(arr[i][j]=='B') {
                    Br = i;
                    Bc = j;
                }
            }
        }

        System.out.println(process(Rr,Rc,Br,Bc));
    }

    public static int process(int lRr, int lRc, int lBr, int lBc) {
        Queue<Balls> q = new LinkedList<>();
        q.add(new Balls(lRr,lRc,lBr,lBc));
        visit[lRr][lRc][lBr][lBc] = true;
        int time =1;

        ball nRed = null;
        ball nBlue = null;

        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Balls current = q.poll();
                for(int k=0; k<4; k++){
                    nRed = move(current.Rr, current.Rc, 0, k);
                    nBlue = move(current.Br, current.Bc, 0, k);

                    if(arr[nBlue.r][nBlue.c]=='O') {
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

                    q.add(new Balls(nRed.r,nRed.c,nBlue.r,nBlue.c));
                }
            }
            if(++time>10) return 0;
        }
        return 0;
    }

    public static ball move(int r, int c, int dist, int k) {
        int rr = r; int cc =c;
        while(arr[rr+dir[k][0]][cc+dir[k][1]]!='#'&& arr[rr][cc]!='O'){
            rr += dir[k][0];
            cc += dir[k][1];
            dist ++;
        }
        return new ball(rr,cc,dist);
    }
}
