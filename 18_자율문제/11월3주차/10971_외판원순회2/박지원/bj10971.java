import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj10971 {
	static int n;
	static int[][] w;
	static boolean[] visited;
	static long result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(str[j]);
			}
			
		}
		//입력 끝
		//출발지 매번 다르고, 다시 돌아오는거까지 비용 계산해야함!!!
		// 하지만 출발지를 매번 다르게해도 최솟값은 동일하다 그러니 한번만 돌려도됨!!
		//0번점을 출발지로 잡고 돌린다.
		visited[0] = true;
		dfs(0, 0, 0);

		System.out.println(result);
		
	}
	static void dfs(int start, int now, long cost) {
		if (allVisited()) { // 다방문했나요 ?
			if (w[now][start] != 0) { // 출발지까지 갈수있나요 ?
				result = Math.min(result, cost + w[now][0]); // 최솟값 비교
			}
			return;
		}
		for (int i = 1; i < n; i++) { // 1번부터 ~ n-1까지 돌면서
			if (!visited[i] && w[now][i] != 0) { // 방문안했고, 0이아니라면 방문해주자
				visited[i] = true;
				dfs(start, i, cost + w[now][i]);
				visited[i] = false;
			}
		}
	}
	static boolean allVisited() {
		for (int i = 0; i < n; i++) { // 방문 안한지점있으면 falase
			if (!visited[i])
				return false;
		}
		return true; // 방문전부다했는뎁쇼? 트루
	}
	
}
