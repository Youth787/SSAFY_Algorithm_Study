import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n];
		arr = new int[m];
		dfs(0);
		System.out.println(sb);

	}

	private static void dfs(int depth) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			// 해당 노드를 방문하지 않았다면
			if (!visit[i]) {
				visit[i] = true; // 해당 노드 방문상태 변경
				arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장
				dfs(depth + 1);// 다음 자식 노드 방문 위해 depth 1 증가시키며 재귀 호출
				visit[i] = false; // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
			}
		}
	}
}
