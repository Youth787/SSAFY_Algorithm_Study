package _11월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 촌수계산 {
	static boolean visit[];
	static List<Integer>[] list;
	static int[][] arr;
	static int N, a, b;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		a = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);

		int M = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			arr[parent][child] = arr[child][parent] = 1;
		} // 입력 완료

		bfs(a);
		System.out.println(cnt);
	}// main end

	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		visit[idx] = true;
		queue.add(idx);

		while (!queue.isEmpty()) {
			int size = queue.size(); // 현재 레벨의 노드 개수
			for (int j = 0; j < size; j++) {
				int current = queue.poll();
				if (current == b) {
					return;
				}
				for (int i = 1; i <= N; i++) {
					if (arr[current][i] == 1 && !visit[i]) {
						visit[i] = true;
						queue.add(i);
					}
				}
			}// 현재 레벨의 노드를 모두 탐색한 후에 cnt 증가 
			cnt++;
		} // while end

		cnt = -1;
	}// method end

}
