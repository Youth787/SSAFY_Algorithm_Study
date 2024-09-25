import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, sx, sy, dx, dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (i == 0) {
					sx = x; // 시작 지점
					sy = y;
				} else if (i == n + 1) {
					dx = x; // 도착 지점
					dy = y;
				} else {
					list.add(new int[] { x, y });
				}
			}
			if (bfs(list)) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

	static boolean bfs(List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(new int[] { sx, sy });
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0], py = pos[1];
			if (Math.abs(px - dx) + Math.abs(py - dy) <= 1000) {
				return true;
			}

			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					int nx = list.get(i)[0], ny = list.get(i)[1];
					int dis = Math.abs(px - nx) + Math.abs(py - ny);
					if (dis <= 1000) {
						visited[i] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
		return false;
	}

}
