import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, sy, sx, dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 }, ans;
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') { // 도연이 위치 저장
					sx = i;
					sy = j;
				}
			}
		}
		dfs(sx, sy);
		if (ans != 0)
			System.out.println(ans);
		else
			System.out.println("TT");
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny < 0 || nx < 0 || nx >= N || ny >= M || visit[nx][ny] || map[nx][ny] == 'X')
				continue; // 배열 범위 벗어나거나 방문했거나 벽인경우
			if (map[nx][ny] == 'P') // 사람이면 카운트 증가
				ans++;
			dfs(nx, ny);
		}
	}
}
