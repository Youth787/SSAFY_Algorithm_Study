package _11월1주차문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양한마리_11123 {
	static boolean[][] visit;
	static int H, W, cnt;
	static String[][] arr;
	static int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			visit = new boolean[H][W];
			arr = new String[H][W];
			for (int i = 0; i < H; i++) {
				String[] a = br.readLine().split("");
				for (int j = 0; j < W; j++)
					arr[i][j] = a[j];
			} // 입력받기 완료

			cnt = 0;
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					if (arr[i][j].equals("#") && !visit[i][j]) {
						cnt++;
						DFS(i, j);
					}

			System.out.println(cnt);
		} // test case end
	}// main end

	public static void DFS(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int r = x + dir[i][0];
			int c = y + dir[i][1];
			if (r >= 0 && r < H && c >= 0 && c < W)
				if (!visit[r][c] && arr[r][c].equals("#"))
					DFS(r, c);
		}
		return;
	}
}
