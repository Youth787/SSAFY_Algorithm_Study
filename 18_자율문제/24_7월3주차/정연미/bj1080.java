package SILVER;

import java.io.*;
import java.util.*;

public class bj1080 {
    static int[][] matrix_A;
    static int[][] matrix_B;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix_A = new int[N][M];
        matrix_B = new int[N][M];
        int result = 0;

        for(int i=0; i<2*N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                if(i<N) matrix_A[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                else matrix_B[i-N][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++)
                if(matrix_A[i][j]!=matrix_B[i][j]) {
                    turn(i, j);
                    result++;
                }
        }

        out : for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix_A[i][j]!=matrix_B[i][j]) {
                    result = -1;
                    break out;
                }
            }
        }

        System.out.println(result);
    }
    public static void turn(int x, int y){
        for(int i=0; i<3;i++)
            for(int j=0;j<3;j++)
                matrix_A[x+i][y+j] = matrix_A[x+i][y+j]==1?0:1;
    }
}
