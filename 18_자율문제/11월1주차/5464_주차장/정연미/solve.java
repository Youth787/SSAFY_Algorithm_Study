package _11월1주차문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주차장_5464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] parkedcar = new int[N + 1];
		int[] parkingpay = new int[N + 1];
		int[] carweight = new int[M + 1];

		for (int i = 1; i <= N; i++)
			parkingpay[i] = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++)
			carweight[i] = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		
		int k = 2 * M;
		int pay = 0;
		out:for (int j = 0; j < k; j++) {
			int move = Integer.parseInt(br.readLine());
			// 차량이 들어올 경우
			if (move > 0) {
				// 주차 자리가 있으면 주차
				for (int i = 1; i <= N; i++) {
					if (parkedcar[i] == 0) {
						parkedcar[i] = move;
						continue out;
					}
				}
				// 없으면 큐에 넣는다.
				queue.offer(move);

				// 차량이 나갈 경우
			} else {
				// 주차 자리 0으로 만든다.
				for (int i = 1; i <= N; i++) {
					if (parkedcar[i] == move * (-1)) {
						parkedcar[i] = 0;
						pay += carweight[move * (-1)] * parkingpay[i];
						// 만약 큐에 자동차 있다면 해당 자리에 큐에 있던 자동차를 넣는다.
						if (!queue.isEmpty())
							parkedcar[i] = queue.poll();
						break;
					}
				}
			}
		}
		System.out.println(pay);
	}// main end
}
