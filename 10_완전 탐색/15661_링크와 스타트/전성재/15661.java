import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		visit = new boolean[n];
		solve(0);
		System.out.println(min);
	}

	static void solve(int depth) {
		if (depth == n) {
			check();
			return;
		}
		visit[depth] = true;
		solve(depth + 1);
		visit[depth] = false;
		solve(depth + 1);
	}

	private static void check() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (visit[i] != visit[j])
					continue;

				if (visit[i])
					start += arr[i][j] + arr[j][i];
				else
					link += arr[i][j] + arr[j][i];

			}
		}
		min = Math.min(Math.abs(start - link), min);
	}
}
