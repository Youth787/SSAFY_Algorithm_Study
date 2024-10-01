package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14890 {
    static int N, L;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=0; i<N; i++){
            if (calRow(i)) result++;
            if (calCol(i)) result++;
        }// 행 확인

        System.out.println(result);
    }
    public static boolean calRow(int r){
        boolean[] visit = new boolean[N];
        for(int i=0; i<N-1; i++){
            if(arr[r][i]==arr[r][i+1]) continue;
            if(Math.abs(arr[r][i]-arr[r][i+1])>1) return false;

            if(arr[r][i]>arr[r][i+1]){ // 왼쪽이 높고, 오른쪽이 낮은경우
                // 경사로 설치가 가능한가?
                if(i+L>=N) return false;
                for(int j=i+1; j<=i+L;j++){
                    if(arr[r][j] != arr[r][i+1] || visit[j]) return false;
                    visit[j] = true;
                }
            }else { // 오른쪽이 높고, 왼쪽이 낮은 경우
                if(i-L+1<0) return false;
                for(int j=i; j>=i-L+1; j--){
                    if(arr[r][j]!=arr[r][i] || visit[j]) return false;
                    visit[j] = true;
                }
            }
        }
        return true;
    }

    public static boolean calCol(int c){
        boolean[] visit = new boolean[N];
        for(int i=0; i<N-1; i++){
            if(arr[i][c]==arr[i+1][c]) continue;
            if(Math.abs(arr[i][c]-arr[i+1][c])>1) return false;

            if(arr[i][c]>arr[i+1][c]){ // 왼쪽이 높고, 오른쪽이 낮은경우
                // 경사로 설치가 가능한가?
                if(i+L>=N) return false;
                for(int j=i+1; j<=i+L;j++){
                    if(arr[j][c] != arr[i+1][c] || visit[j]) return false;
                    visit[j] = true;
                }
            }else { // 오른쪽이 높고, 왼쪽이 낮은 경우
                if(i-L+1<0) return false;
                for(int j=i; j>=i-L+1; j--){
                    if(arr[j][c]!=arr[i][c] || visit[j]) return false;
                    visit[j] = true;
                }
            }
        }
        return true;
    }
}
