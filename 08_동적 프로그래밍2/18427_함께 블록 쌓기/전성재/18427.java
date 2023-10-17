import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int h = Integer.parseInt(s[2]);
		int[][] dp = new int[n + 1][1001];

		List<Integer>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= h; j++) {
				for (Integer integer : list[i]) {
					if (j >= integer) { // j>=integer이 의미하는 것은 내가 가진 블록값 + 이전까지 만든 블록의 값을 더해서 경우의 수를 만들 수 있다는 뜻!
						dp[i][j] += dp[i - 1][j - integer];
						dp[i][j] %= 10007;
					}
				}
				dp[i][j] += dp[i - 1][j];  // 이전까지 값이 만들어진 경우를 더하기!
				dp[i][j] %= 10007;
			}
		}
		System.out.println(dp[n][h]);
	}
}
