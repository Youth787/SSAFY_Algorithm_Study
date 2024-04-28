package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

//cloud class 생성하고 
//queue로 다시 풀어  

public class 마법사상어와비바라기 {
    static int N,M;
    static int[][] move;
    static int[][] arr;
    static int d,s;
    static int[][] dir = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int[][] pos;

    static int[][] fourpath = new int[][]{{1,1},{-1,-1},{1,-1},{-1,1}};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new int[][]{{N-2,0},{N-2,1},{N-1,0},{N-1,1}};
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }
        // 입력받기 완료

        for(int i=0; i<M; i++){
            d = move[i][0];
            s = move[i][1];
            translate();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }
    public static void translate() {
        for (int i = 0; i < 4; i++) {
            int mr =s * dir[d - 1][0];
            int mc =s * dir[d - 1][1];

            if(mr<0) mr = N + mr%N;
            if(mc<0) mc = N + mc%N;

            pos[i][0] = (pos[i][0]+ mr)%N;
            pos[i][1] = (pos[i][1]+ mc)%N;
//          System.out.println(i+"번째전환 "+"mr : "+pos[i][0] +" mc : "+pos[i][1]);

            // 옮긴후의 위치에 4칸의 값을 ++ 시킨다.
            arr[pos[i][0]][pos[i][1]] += 1;
        }

        // 이제 각각의 4위치에서 사방 대각선을 보고 물이 있는경우 만큼 해당위치 값 증가시키기
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int r = pos[i][0] + fourpath[k][0];
                int c = pos[i][1] + fourpath[k][1];
                if (r >= 0 && c >= 0 && r < N && c < N && arr[r][c] != 0) {
                    cnt += 1;
                }
            }
            arr[pos[i][0]][pos[i][1]] += cnt;
        }

        // 이제 바구니 위치 제외, 저장된 물이 2이상인 칸에 물양 -2하기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if((i==pos[0][0] && j==pos[0][1])||(i==pos[1][0] && j==pos[1][1])||(i==pos[2][0] && j==pos[2][1])||(i==pos[3][0] && j==pos[3][1])) continue;
                if(arr[i][j] >= 2) arr[i][j] -=2;
            }
        }

    }
}
