import java.util.Scanner;
/*
[문제] n개의 식재료를 각각 n/2개씩 나누어 2가지 요리를 할 때, 두 음식의 맛(사용 재료의 시너지 합)의 차이 최소값 찾기
[입력] t, n, n개의 줄에 시너지 값 주어짐(같은 재료는  0으로 출력)
 */
class Solution {
    static int n; 
    static int mini; //맛 차이 최솟값
    static int[][] sng;	//시너지
    static boolean[] chk;	//방문배열
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();

		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
            sng = new int[n][n];
            chk = new boolean[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                	sng[i][j] = sc.nextInt();
                    mini += sng[i][j];		// 최댓값으로 초기화
                }
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + mini);
		}
	}
    static void dfs(int cnt, int idx) {
        if(cnt == n / 2) {
            int sum1 = 0; 
            int sum2 = 0;
            for(int i = 0; i < n; i++) {
            	for(int j = i + 1; j < n; j++){
                if(chk[i] && chk[j]) {
                    sum1 += sng[i][j] + sng[j][i]; // 고른 식재료로 만든 음식
                } else if(!chk[i] && !chk[j]) {
                    sum2 += sng[i][j] + sng[j][i]; // 나머지 식재료로 만든 음식
                }
              }
            }
            int diff = Math.abs(sum1 - sum2);	// 맛의 차이
            mini = Math.min(mini, diff);		// 최솟값 비교
            return;
        }
      
        for(int i = idx; i < n; i++) {
            chk[i] = true;
			      dfs(cnt+1, i+1);
            chk[i] = false;
        }
    }
}//class
