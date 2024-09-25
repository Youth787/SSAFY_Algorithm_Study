import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sh, tosh; // 양의 수
	static int wo, towo; // 늑대 수
	static char map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r;
	static int c;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = new boolean[r][c];
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력 받기

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				wo = 0;
				sh = 0;
				if (!visited[i][j]) {
					if (map[i][j] != '#') {
						dfs(i, j);
					}
				}
				if (wo < sh) {
					wo = 0;
				} else {
					sh = 0;
				}
				towo += wo;
				tosh += sh;
			}
		}
		System.out.print(tosh + " ");
		System.out.print(towo);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		int dr = 0;
		int dc = 0;
		if (map[x][y] == 'v') {
			wo++;
		} else if (map[x][y] == 'o') {
			sh++;
		}
		for (int i = 0; i < 4; i++) {
			dr = x + dx[i];
			dc = y + dy[i];

			if (dr >= 0 && dc >= 0 && dr < r && dc < c) {
				if (!visited[dr][dc] && map[dr][dc] != '#') {
					dfs(dr, dc);
				}
			}
		}
	}

}
