import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visit[];
	static int n, m, v;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		v = 1;
		arr = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = arr[end][start] = 1;

		}
		System.out.println(dfs(1));

	}

	public static int dfs(int i) {
		visit[i] = true;
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == 1 && visit[j] == false) {
				count++;
				dfs(j);
			}
		}
		return count;
	}

}
