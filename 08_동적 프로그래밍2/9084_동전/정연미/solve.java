package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] money = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				money[i] = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(br.readLine()); // 입력받기 완료

			int[] dp = new int[M + 1];

			for (int j = 0; j < N; j++) {// 거스름돈 개수만큼 
				for (int i = 1; i <= M; i++) {// 입력값을 돈다. 1원부터 
					if(i>=money[j]) {
						if(i-money[j]==0) dp[i] = dp[i]+1;
						else dp[i] = dp[i-money[j]]+dp[i];
					}
				}
			}
			System.out.println(dp[M]);
		} // test case end
	}// main end
}
