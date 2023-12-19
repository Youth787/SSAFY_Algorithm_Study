import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char arr[][] = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int answer = 0;

	static class node {
		int r, c;

		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				arr[i][j] = s.charAt(j);
			}
		} // 입력 받기
		while (true) {
			for (int i = 0; i < 12; i++) {
				Arrays.fill(visited[i], false);
			}
			int cnt = 0;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && arr[i][j] != '.') {
						if (bfs(i, j)) {
							cnt++;
						}
					}
				}
			}

			if (cnt == 0) {
				break;
			}
			answer++;
			gravity();

		}
		System.out.println(answer);

	}

	static boolean bfs(int r, int c) {
		Queue<node> q = new LinkedList<>();
		List<node> l = new ArrayList<>();

		q.offer(new node(r, c));
		l.add(new node(r, c));
		visited[r][c] = true;
		char color = arr[r][c];
		while (!q.isEmpty()) {
			node temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int newx = temp.r + dx[i];
				int newy = temp.c + dy[i];

				if (newx >= 0 && newx < 12 && newy >= 0 && newy < 6 && arr[newx][newy] == color
						&& !visited[newx][newy]) {
					l.add(new node(newx, newy));
					q.offer(new node(newx, newy));
					visited[newx][newy] = true;
				}
			}
		}

		if (l.size() >= 4) {
			for (node temp : l) {
				arr[temp.r][temp.c] = '.';
			}
			return true;
		}
		return false;

	}

	static void gravity() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (arr[j][i] != '.') {
					int nr = j;
					while (true) {
						nr++;
						if (nr >= 0 && nr < 12 && i >= 0 && i < 6 && arr[nr][i] == '.') {
							arr[nr][i] = arr[nr - 1][i];
							arr[nr - 1][i] = '.';
						} else {
							break;
						}
					}
				}
			}
		}
	}
}
