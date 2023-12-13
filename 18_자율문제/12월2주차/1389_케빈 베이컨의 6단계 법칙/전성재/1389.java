import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean visited[];
	static int n;
	static int m;
	static int map[][];
	static Queue<Integer> q;
	static int cnt = 0;
	static int answer, total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;

		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];

			total = 0;
			bfs(i);
			if (total < min) {
				min = total;
				answer = i;
			}
		}

		System.out.println(answer);

	}

	static void bfs(int x) {

		cnt = 0;
		q.offer(x);
		visited[x] = true;

		while (!q.isEmpty()) {
			cnt++;
			int len = q.size();
			for (int l = 0; l < len; l++) {
				int temp = q.poll();
				for (int i = 1; i <= n; i++) {
					if (!visited[i] && map[temp][i] == 1) {
						q.offer(i);
						visited[i] = true;
						total += cnt;
					}
				}
			}
		}

	}

}
