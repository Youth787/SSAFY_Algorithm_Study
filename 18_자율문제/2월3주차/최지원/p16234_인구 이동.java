import java.util.*;
import java.io.*;
/*
 * n*n 땅, 각 칸은 각각 나라. 국경선 존재
 * 인구 차이가 범위 내라면 하루동안 공유하는 국경선을 연다
 * 열려야 할 국경선을 모두 열고 인구이동 시작
 * 이동가능한 경우 "연합", 연합을 이루고 있는 각 칸의 인구수 = (연합인 나라 인구 합) / (연합국 수). 소수점 버림
 * 인구 수가 주어졌을 때, 인구 이동이 며칠동안 발생하는지 구하기
 */
public class Main {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, L, R;
	static boolean flag;
	static int[][] map;
	static boolean[][] v;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		flag = true;
		int answer = -1;

		while (flag) {
			v = new boolean[N][N];
			flag = false;

			shareCountry();
			answer++;

		}
		System.out.println(answer);
	}

	static Queue<Point> que;

	private static void shareCountry() {
		que = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					que.offer(new Point(r, c));
					v[r][c] = true;
					int sum = map[r][c];
					tmq = new LinkedList<>();
					tmq.offer(new Point(r, c));
					bfs(sum);
				}
			}
		}
	}

	static Queue<Point> tmq;

	private static void bfs(int sum) {
		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!check(nr, nc))
					continue;
				int val = Math.abs(map[nr][nc] - map[cur.r][cur.c]);

				if (!v[nr][nc] && (val >= L && val <= R)) {
					sum += map[nr][nc];
					v[nr][nc] = true;
					que.offer(new Point(nr, nc));
					tmq.offer(new Point(nr, nc));
					flag = true;

				}
			}
		}
		
        movePeople(sum);

	}

	private static void movePeople(int sum) {
		//print();
		//System.out.println();
		int p = sum / tmq.size();
		while (!tmq.isEmpty()) {
			Point cur = tmq.poll();
			map[cur.r][cur.c] = p;
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
