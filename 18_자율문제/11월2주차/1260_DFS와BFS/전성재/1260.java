import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	public static boolean[] visited_dfs;
	public static boolean[] visited_bfs;
	public static Stack<Integer> stack = new Stack<>();
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[s][e] = true;
			arr[e][s] = true;

		}

		StringBuilder dfssb = new StringBuilder();
		visited_dfs = new boolean[N + 1];

		stack.push(V);

		while (!stack.isEmpty()) {
			int p = stack.pop();

			if (visited_dfs[p]) {
				continue;
			}
			visited_dfs[p] = true;
			dfssb.append(p).append(" ");

			for (int i = N; i >= 1; i--) {
				if (!arr[p][i] || visited_dfs[i]) {
					continue;
				}
				stack.push(i);
			} // 정점을 추가 및 전부 돌기

		}

		StringBuilder bfssb = new StringBuilder();
		visited_bfs = new boolean[N + 1];

		queue.offer(V);
		visited_bfs[V] = true;

		while (!queue.isEmpty()) {
			int q = queue.poll();
			bfssb.append(q).append(" ");

			for (int i = 1; i <= N; i++) {
				if (!arr[q][i] || visited_bfs[i]) {
					continue;
				}

				queue.offer(i);
				visited_bfs[i] = true;
			}
		}

		System.out.println(dfssb);
		System.out.println(bfssb);
	}

}
