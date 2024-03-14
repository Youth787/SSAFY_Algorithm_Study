
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 각 학생이 가진 블록의 최대 개수
		int h = Integer.parseInt(st.nextToken()); // 목표로 하는 탑의 높이
		int[][] board = new int[n][m]; // 각 학생의 블록 높이 정보를 저장할 배열

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력

		//배열 초기화(1번째부터 있으니까 사이즈)
		int[][] dp = new int[n+1][h+1]; // dp[i][j]= i번째 학생까지 & 높이 j를 만드는 경우의 수
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1; // 높이 0을 만드는 경우 = 항상 1 (아무 블록도 사용하지 않는 경우)
		}

		for (int i = 1; i <= n; i++) { // 각 학생을 도는 for문
			for (int j = 1; j <= h; j++) { // 목표 높이까지의 가능한 모든 높이를 도는 for문
				// 문제에서 "단, 어떤 학생의 블록은 사용하지 않아도 되며 한 학생당 최대 1개의 블록만을 사용할 수 있다." 
				dp[i][j] = dp[i-1][j]; // 현재 학생의 블록을 사용하지 않는 경우의 수를 먼저 추가
				for (int k = 1; k <= m; k++) { // 현재 학생이 가진 모든 블록을 도는 for문
					if(board[i-1][k-1] == 0) {
						continue;
					} // 해당 학생이 더 이상 가진 블록이 없는 경우
					if(j - board[i-1][k-1] >= 0) { // 현재 학생의 블록을 사용할 수 있는 경우
						dp[i][j] += dp[i-1][j - board[i-1][k-1]]; // 해당 블록을 사용하는 경우의 수를 추가
						dp[i][j] %= 10007; // 결과를 10007로 나눈 나머지로 유지
					}
				}
			}
		}

		// 최종 결과 출력
		System.out.println(dp[n][h]);
	} //main
} //class
