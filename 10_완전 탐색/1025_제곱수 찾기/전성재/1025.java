import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//예제 입력1
//2 3
//123
//456
//
//예제 입력2
//6 7
//3791178
//1283252
//4103617
//8233494
//8725572
//2937261
public class Main {
	// 입력 배열
	static String s;
	static int[][] map;

	static int N, M;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			s = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) { // 행 시작 부분 제한
			for (int j = 0; j < M; j++) { // 열 시작 부분 제한

				// 제한된 범위인 i x j를 파라미터로 메서드 호출
				solve(i, j);
			}
		}

		System.out.println(min);

	}

	public static void solve(int r, int c) {
		for (int i = -N; i < N; i++) { // 행 공차
			for (int j = -M; j < M; j++) { // 열 공차

				// (i=0, j=0 일 때는 의미가 없으니, 무한 반복)
				if (i == 0 && j == 0)
					continue;

				int x = r; // 제한된 행 시작 부분
				int y = c; // 제한된 열 시작 부분

				// 만들어질 제곱수
				int sqr = 0;

				// 범위 체크
				while (0 <= x && x < N && 0 <= y && y < M) {
					// 제곱수 생성
					sqr *= 10;
					sqr += map[x][y];

					// 제곱근 구하기
					int root = (int) Math.sqrt(sqr);

					// 제곱수 판별
					if (Math.pow(root, 2) == sqr)
						max = Math.max(min, sqr);

					x += i;
					y += j;
				}
			}
		}
	}

}
