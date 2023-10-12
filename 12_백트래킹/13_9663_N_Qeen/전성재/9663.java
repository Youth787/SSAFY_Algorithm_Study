import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int map[][];
	static boolean visit[][];
	static int result = 0;

	static int queen[]; // queen[행] = 열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		queen = new int[n];
		
//		Arrays.fill(queen, -18);
		backTracking(0);

		System.out.println(result);
	}

	// idx : 행
	private static void backTracking(int idx) {
		// 탈출 조건
		if (idx == n ) {
			result++;
			return;
		}

		// i : 열값
		for (int i = 0; i < n; i++) {
			// 첫 행 (비교 x)
			queen[idx] = i;
			// check true면 다음 행으로/ 퀸을 놓을 수 없으면 다음 열값을 저장해서 확인
			if (idx == 0 || check(idx))
				backTracking(idx + 1);

		}
	}

	public static boolean check(int check) {
		for (int j = 0; j < check; j++) {
			// queen[j(행)] : 열값 == queen[check(현재 행)] : 열값
			// j- check(행 거리) == 열거리 -> 대각선 상에 존재
			if (queen[j] == queen[check] ||check - j == Math.abs(queen[j] - queen[check]))
				return false;
		}

		return true;
	}

}
