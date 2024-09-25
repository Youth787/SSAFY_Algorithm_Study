import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int m, n, h, answer;
	static int[][][] arr;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	static class Point {

		int x, y, z;

		public Point(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		answer = 1;

		arr = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					arr[i][j][k] = sc.nextInt();
					if (arr[i][j][k] == 1) {
						queue.offer(new Point(i, j, k));
					}
				}
			}
		}

		System.out.println(solve());
	}

	public static int solve() {
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];
				int nextZ = poll.z + dz[i];

				if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < n && nextY < m && nextZ < h) {
					if (arr[nextZ][nextX][nextY] == 0) {
						queue.offer(new Point(nextZ, nextX, nextY));
						arr[nextZ][nextX][nextY] = arr[poll.z][poll.x][poll.y] + 1;
					}
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (arr[i][j][k] == 0) {
						return -1;
					}
					answer = Math.max(answer, arr[i][j][k]);
				}
			}
		}
		if (answer == 1) {
			return 0;
		} else {
			return answer - 1;
		}
	}
}
