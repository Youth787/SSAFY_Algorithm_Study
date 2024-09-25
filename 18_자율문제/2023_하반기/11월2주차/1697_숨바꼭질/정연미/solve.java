package _11월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
	static int[] input;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		input = new int[2];
		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		memo = new int[100001];
		Arrays.fill(memo, -1);
		BFS();

		System.out.println(memo[input[1]]);
	}// main end

	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(input[0]);
		memo[input[0]] = 0;

		while (!queue.isEmpty()) {
			if (memo[input[1]] != -1)
				return;

			int d = queue.poll();

			if (d+1 < 100001 && memo[d + 1] == -1) {
				queue.offer(d+1);
				memo[d + 1] = memo[d] + 1;
			}
			if (d-1 >= 0 && memo[d - 1] == -1) {
				queue.offer(d-1);
				memo[d - 1] = memo[d] + 1;
			}
			if (d*2 < 100001 && memo[d * 2] == -1) {
				queue.offer(d*2);
				memo[d * 2] = memo[d] + 1;
			}

		}// while end
	}// method end 
}
