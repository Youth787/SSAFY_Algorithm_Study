import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int n, m, answer;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (arr[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
//			치킨집에 해당하는 값을 치킨리스트에, 집에 해당하는 값을 집 리스트에 담습니다.
			
		}

		answer = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];

		solve(0, 0);
		System.out.println(answer);

	}

	public static void solve(int start, int cnt) {
		if (cnt == m) {
			int res = 0;

			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j]) {
						int dist = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);

						temp = Math.min(temp, dist);
					}
				}
				res += temp;
			}
			answer = Math.min(answer, res);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			visited[i] = true;
			solve(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
