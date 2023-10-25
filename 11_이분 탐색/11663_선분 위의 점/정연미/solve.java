package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11663_선분위의점 {
	static Long[] dot;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dot = new Long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			dot[i] = Long.parseLong(st.nextToken());

		Arrays.sort(dot);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = BinarySearch(a, b);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}// main end

	public static int BinarySearch(int a, int b) {
		// 왼쪽 좌표
		int st = 0;
		int ed = dot.length - 1;

		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (a > dot[mid])
				st = mid + 1;
			else
				ed = mid - 1;
		}
		int x = st;

		// 오른쪽 좌표
		st = 0;
		ed = dot.length - 1;

		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (b >= dot[mid])
				st = mid + 1;
			else
				ed = mid - 1;
		}
		int y = ed + 1;

		return y - x;
	}// method end
}
