package GOLD.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오토에버 소프티어 문제와 유사
public class 벽부수고이동하기 {
    // 미구현
    // 벽하나 부수는 경우 추가 해야한다. 
    static int N, M, result;
    static int[][] arr;
    static int[][] dir = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력받기 완료
        
        result = Integer.MAX_VALUE;
        run(0,0,1);
        System.out.println(result);
    }
    public static void run(int i, int j, int min){
        if(i==N && j==M) {
            result = Math.min(result, min);
        }
        int r = i;
        int c= j;
        for(int k=0; k<4; k++){
            r = i+dir[k][0];
            c = j+dir[k][1];
            if(r>=0 && c>=0 && r<N && c<M && arr[r][c]==0) {
                run(r, c, min+1);
            }
        }
    }
}
