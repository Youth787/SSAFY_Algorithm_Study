import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][2];

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		k = Integer.parseInt(br.readLine());

		dfs(0, 1, false);
		System.out.println(min);
	}

	static void dfs(int sum, int start, boolean flag) {
		if (start == n) {
			min = Math.min(min, sum);
			return;
		}
		if (start > n) {
			return;
		}
		dfs(sum + arr[start][0], start + 1, flag); // 1칸 넘어갈 때
		dfs(sum + arr[start][1], start + 2, flag); // 2칸 넘어갈 때

		if (!flag) { // 3칸 넘어갈 때 체크
			dfs(sum + k, start + 3, true);
		}
	}

}
