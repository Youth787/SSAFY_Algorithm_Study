///공부가 필요하다아
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static int n; 
    static int ans;
    static int[][] arr;
    static int visited;
    static int[] sel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt(); // 고객 수
            arr = new int[n+2][2]; //행을 인덱스로 한 열 좌표값
            ans = 1200; //최단경로의 이동거리
            for(int i=0; i<n+2; i++) { //i => 0:회사, 1:집
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            } //좌표입력
            //2~n+1까지 고객집주소 순열 = 1번테케에선 5개
            sel = new int[n];
            visited = 0;
            visit(0, visited);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
 
    public static void visit(int idx, int visited) { // q의 크기
        // 기저
        if (idx == n) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                //첫집은 회사랑
                if(i==0) sum += Math.abs(arr[sel[i]][0]-arr[0][0])+Math.abs(arr[sel[i]][1]-arr[0][1]);
                else sum += Math.abs(arr[sel[i]][0]-arr[sel[i-1]][0])+Math.abs(arr[sel[i]][1]-arr[sel[i-1]][1]);
            }
            sum += Math.abs(arr[sel[n-1]][0]-arr[1][0])+Math.abs(arr[sel[n-1]][1]-arr[1][1]); //집이랑
            if(ans>sum)  ans = sum;
            return;
        }
        // 재귀 - 집 다섯개를 각각 인덱스에 넣어보기
        for (int k = 0; k < n; k++) {
            if ((visited & (1<<k)) != 0) continue; //이미 방문한 곳이면 패스
          
            //체크 후 재귀
            sel[idx] = k+2; //집번호 입력
            visit(idx+1, visited | 1<<k);
            //원상복구 : visited는 필요없음
        }
    }
}
