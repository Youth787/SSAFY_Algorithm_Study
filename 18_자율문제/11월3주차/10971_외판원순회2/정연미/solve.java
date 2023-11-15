package _11월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 외판원순회 {
	static int[][] cost;
	static int[] arr;
	static int N;
	static boolean[] visit;
	static int min = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cost = new int[N][N];
		arr = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(input[j]);
			}
		} // 입력받기 완료
		NCN(0);
		System.out.println(min);
	}// main end

	// N개의 조합을 구한다.
	// 조합마다 길의 값을 더한다.
	// 값이 최소가 되도록 한다.
	public static void NCN(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (cost[arr[i % N]][arr[(i + 1) % N]] == 0) 
					break;
				sum += cost[arr[i % N]][arr[(i + 1) % N]];
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				arr[depth] = i;
				visit[i] = true;
				NCN(depth + 1);
				visit[i] = false;
			}
		}
	}// method end
}
