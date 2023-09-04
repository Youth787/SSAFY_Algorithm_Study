import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println(bridge(M, N));

		}

	}

	static int bridge(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r]; // 기존 선택된 다리 리턴
		}

		if (n == r || r == 0) {
			return dp[n][r] = 1; // n과 r이 같을 때와 r이 0일 때 1인 것을 이용해서 값을 구하기
		}

		return dp[n][r] = bridge(n - 1, r - 1) + bridge(n - 1, r); // nCr 공식

	}
}
