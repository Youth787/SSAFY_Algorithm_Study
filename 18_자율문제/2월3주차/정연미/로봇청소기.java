package ALGO_STUDY.Fev_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
    static int clean=0;
    static int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M,d,r,c;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        // 사방이 벽이다. 벽은 1이다.
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr= new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 탐색하는 메서드 실행
        cleanroom(r,c);
        // 청소한 칸의 개수 출력
        System.out.println(clean);
    }

    // 4방향 탐색.(왼쪽으로 회전하며) 0인 칸이면, 해당 칸으로 이동하고., 해당 칸을 청소 => 다시 4방향 탐색
    // 0인 칸이 없으면, d방향 바라본채로 후진. 후진후, 해당칸을 청소(0이면) 청소후 다시 4방향 탐색
    // 후진할 수 없으면 메서드 빠져나옴.
    public static void cleanroom(int r, int c){
        if(arr[r][c] == 0){ // 청소하지 않은 공간이면
            arr[r][c] = 2; // 청소한다.
            clean++;
        }
        // 현재 d 먼저 탐색, 시계방향으로 회전하며 0인 칸찾기.
        for(int i=0; i<4; i++){
            d = (d+3)%4;
            int ar = r+direction[d][0];
            int ac = c +direction[d][1];
            if(arr[ar][ac]==0){
                cleanroom(ar,ac); // 다시 4방향 탐색 들어가기
                return;
            }
        }
        // 0인 칸이 없다!
        // 후진한다.
        int ar = r-direction[d][0];
        int ac = c-direction[d][1];
        
        if(arr[ar][ac]!=1){
            cleanroom(ar, ac);
        }
    } // method end

}
