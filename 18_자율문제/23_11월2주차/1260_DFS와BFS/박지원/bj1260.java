import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1260 {
	static int n, m, v;
	static boolean[][] node;
	static boolean[] visited;
	static Queue<Integer> q;
	static StringBuilder sb_dfs = new StringBuilder();
	static StringBuilder sb_bfs = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		node = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		q = new LinkedList<>();
		for (int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = true;
			node[b][a] = true;
		}
		//입력 끝
    //dfs
		visited[v] = true;
		sb_dfs.append(v).append(" ");
		dfs(v);
		System.out.println(sb_dfs);

    //bfs
		visited = new boolean[n + 1]; // 방문처리 다시해야하니까 다시 초기화
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) { // queue를 사용한다!!
			sb_bfs.append(q.peek()).append(" ");
			int front = q.poll();
			for (int i = 1; i <= n; i++) { 
				if (node[front][i] && !visited[i]) { // 연결되어있고 방문안했어?
					visited[i] = true; // 방문처리하고
					q.add(i); // q에 넣어준다.
				}
			}
		}
		System.out.println(sb_bfs);
	}
	static void dfs(int start) {
		 for (int i = 1; i <= n; i++) { 
			 if (node[start][i] && !visited[i]) { // 연결되어있고, 방문하지않았으면
				 visited[i] = true; // 방문처리해주고
				 sb_dfs.append(i).append(" "); // 답에 바로 넣어
				 dfs(i); // 그리고 그 점으로 dfs돌려
			 }
		 }
		
	}

}
