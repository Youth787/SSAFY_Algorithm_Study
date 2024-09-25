//캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력
//캠퍼스 크기는 n*m. 이동은 벽이 아닌 상하좌우
//n,m은 1 이상 600이하
//O는 빈 공간, X는 벽, I는 도연이, P는 사람
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;//cnt는 만나는 사람 수
	static char [][] campus;
	static boolean [][] visited;
	static int stR, stC;//시작점
	
	static class point{
		int r;
		int c;
		public point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}

	static int[] dr = {0, 0, -1, 1};//좌우상하
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		campus = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();			
			for (int j = 0; j < m; j++) {
				campus[i][j] = str.charAt(j);
				if (campus[i][j] == 'I') {// 도연이 위치
					stR = i;
					stC = j;
				}
			}
		}
		
		cnt = 0; 
		BFS(stR, stC);
		
		if (cnt != 0) System.out.println(cnt);
		else System.out.println("TT");
	}
	
	public static void BFS(int r, int c) {
		Queue <point> queue = new LinkedList<>();
		queue.add(new point(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			point pos = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];
				
				//캠퍼스 범위 밖 또는 이미 방문 또는 벽
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || campus[nr][nc] == 'X') continue;
				
				if (campus[nr][nc] == 'P') cnt++; // 사람 만남
				
				visited[nr][nc] = true;// 방문처리
				queue.add(new point(nr, nc));
			}
		}//queue while문
	}//BFS
}//class
