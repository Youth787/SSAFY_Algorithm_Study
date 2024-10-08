import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 다시풀기 

class IceBerg {
	int x;
	int y;
	
	public IceBerg(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while (true) {
			int result = countIsland();
			
			if (result >= 2) break;
			else if (result == 0) {
				year = 0;
				break;
			}
			
			bfs();
			year++;
		}

		System.out.println(year);
	}
	
	public static int countIsland() {
		boolean[][] visited = new boolean[N][M];
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
		
		return cnt;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) 
				if (!visited[nx][ny] && map[nx][ny] > 0) dfs(nx, ny, visited);
		}
	}
	
	public static void bfs() {
		Queue<IceBerg> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    q.add(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }
		
		while (!q.isEmpty()) {
			IceBerg ice = q.poll();
			
			int sea = 0;
			
			for (int i = 0; i < 4; i++) {
				int nx = ice.x + dx[i];
				int ny = ice.y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] == 0) {
						sea++;
					}
				}
			}
			
			if (map[ice.x][ice.y] - sea < 0) map[ice.x][ice.y] = 0; 
			else map[ice.x][ice.y] -= sea;
		}
	}

}
