import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class bj21736 {
	
	static int n, m, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] mr = {-1, 0, 1, 0};
	static int[] mc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		int start_r = 0;
		int start_c = 0;
		ans = 0;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
			
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') { // 도연이 찾기
					start_r = i;
					start_c = j;
				}
			}
		}
		//입력 끝
		//o: 빈공간, x:벽, i:도연, p:사람
    
		bfs(start_r, start_c);
    //출력
		if (ans == 0)
			System.out.println("TT");
		else 
			System.out.println(ans);
	}
	static void bfs(int r, int c) { // 너비우선탐색을 돌것입니다.
		Queue<Node> q = new LinkedList<>(); // q를 하나 생성해서 
		q.add(new Node(r, c)); // 도연이 좌표부터 넣어주고
		visited[r][c] = true; // 방문처리해주고
		while (!q.isEmpty()) { // q가 빌때까지 너비우선탐색을 돈다.
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int moveR = node.x + mr[i];
				int moveC = node.y + mc[i];
				if (moveR >= 0 && moveC >= 0 && moveR < n && moveC < m && !visited[moveR][moveC] && map[moveR][moveC] != 'X') {
					if (map[moveR][moveC] == 'P') {
						ans++;
						q.add(new Node(moveR, moveC));
					} else if (map[moveR][moveC] == 'O') {
						q.add(new Node(moveR, moveC));
					}
					visited[moveR][moveC] = true;
				}
			}
		}
		
	}
}
