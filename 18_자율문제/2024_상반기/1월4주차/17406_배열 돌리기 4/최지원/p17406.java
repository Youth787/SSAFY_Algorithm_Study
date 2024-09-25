package p17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

/* .......
 * n*m 배열의 값은 각 행(가로줄)에 있는 모든 수의 합 중 최소값 출력
 * 회전 연산: r c s => 왼위 모서리(r-s,c-s) ~ 오아(r+s,c+s) 정사각형을 시계방향으로 한칸씩 돌린다
 * r-s ~ r ~ r+s / c-s ~ c c+s   
 * 입력: n, m, 회전 연산 횟수 k / 배열 (n줄) / k 줄에 각각 r c s 
 * 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다 = 순서를 바꿔도 된다....난리났다 백트래킹
*/

//전체적인 풀이 순서. 입력 다 받고 
//=> 회전 연산 순서를 바꿔가며 모든 경우의 수 탐색 [백트래킹]
//각 경우의 연산 수행하고 배열 변경
public class Main {   
    static class nums {
        int r, c, s;
        public nums(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    } // 회전 연산

    static int n; //r
	static int m; //c
	static int k; //회전 연산 횟수(1~6)
    static int[][] arr; // 처음 배열 저장
    static boolean[] visited; // 회전했는지 확인
    static ArrayList<nums> rcs = new ArrayList<>(); // rcs 묶어서 저장
    static int ans = Integer.MAX_VALUE; //최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            rcs.add(new nums(r - s, c - s, s * 2));
        } //회전 연산(*0부터 아님 주의) 정보까지 입력 끝
      
        backtracking(0); //회전 연산 순서 바꾸며 최소값 구하기
        System.out.println(ans);
    } //main

    static void backtracking(int depth) {
        if (depth == k) {
            calculation(); //회전 연산을 모두 진행했을때 => 계산을 해본다
            return;
        }
        // 기존 배열 복사
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, m);
        }
        // 회전 연산 탐색
        for (int i = 0; i < k; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true; //방문처리
            rotation(rcs.get(i)); //회전 정보 불러와서 바꾸고
            backtracking(depth + 1); //안쪽도 회전
		
            visited[i] = false; //복구1
            rollback(temp); //복구2
        }
    } //최소값 찾기 backtracking
 
    static void calculation() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++)
                temp += arr[i][j];
            res = Math.min(res, temp);
        }
        ans = Math.min(ans, res); // 최소값 비교
    } //calculation 최소값 계산

    static void rotation(nums value) {
    	//시계방향(달팽이 문제?)으로 돌고, (r,c)는 고정이고 그 밖에 시계방향 도는거는 (r,c) 나올때까지 s층?동안 수행하게 됨
    	for (int i = 0; i < value.s / 2; i++) {
    		int r1 = value.r + i; 
    		int c1 = value.c + i; //왼위
    		int r2 = value.r + value.s - i; 
            int c2 = value.c + value.s - i; //오아
            int temp = arr[r1][c1]; //시작점(기준)
            for (int j = r1; j < r2; j++) {
                 arr[j][c1] = arr[j + 1][c1];
            } //위
            for (int j = c1; j < c2; j++) {
            	arr[r2][j] = arr[r2][j + 1];
            } //왼
            for (int j = r2; j > r1; j--) {
                arr[j][c2] = arr[j - 1][c2];
            }//아
            for (int j = c2; j > c1 + 1; j--) {
                arr[r1][j] = arr[r1][j - 1];
            } //오
            arr[r1][c1 + 1] = temp; // 기준 값도
        }
    } //rotation 회전 연산

    static void rollback(int[][] temp) {
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, m);
        }
    } //rollback 백트래킹용
} //class
