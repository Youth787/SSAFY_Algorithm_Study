import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔1106 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C + 101];

		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			for (int j = customer; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], dp[j - customer] + cost);
			}
		} // 입력 완료

		int result = 987654321;
		for (int i = C; i < C+101; i++) {
			result = Math.min(dp[i], result);
		}
		System.out.println(result);
	}// main end
}