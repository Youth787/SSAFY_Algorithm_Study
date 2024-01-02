import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node {
	int end;
	int cost;

	public node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수

		List<node>[] list = new List[n + 1]; // 각 선에 대한 정보
		boolean[] visited = new boolean[n + 1]; // 각 정점에 대한 방문 여부
		List<Integer>[] recity = new List[n + 1]; // 해당 정점을 방문하기 전 방문한 정점
		int[] recost = new int[n + 1]; // 해당 정점을 방문하기 위한 최소 비용

		// 초기화
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			recity[i] = new ArrayList<>();
			recost[i] = Integer.MAX_VALUE;

		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new node(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 다익스트라
		PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		recity[start].add(start); // 출발 정점에 대한 정보 저장
		recost[start] = 0; // 출발 정점의 최소비용은 0
		queue.add(new node(start, 0)); // 출발 정점 queue에 추가

		while (!queue.isEmpty()) {
			node now = queue.poll(); // 현재 방문할 정점
			// 현재 방문할 정점에 가는 최소 비용이 이미 저장된 값보다 지금 방문하려고 할 때 드는 비용이 더 크다면 pass
			if (recost[now.end] < now.cost)
				continue;
			if (!visited[now.end]) {
				visited[now.end] = true;
			} // 현재 방문할 정점 방문 처리
				// 현재 방문할 정점에서 이동할 수 있는 정점에 대하여 조사
			for (int i = 0; i < list[now.end].size(); i++) {
				node next = list[now.end].get(i); // 다음 방문할 정점
				// 다음 방문할 정점이 방문하지 않았고, 최소 비용이 든다면
				if (!visited[next.end] && now.cost + next.cost <= recost[next.end]) {
					recost[next.end] = now.cost + next.cost; // 비용 Update
					recity[next.end].clear(); // 현재까지 이동했던 좌표들에 대한 내용 clear
					// 이제까지 이동했던 내용에 대해서 다시 update
					for (int j = 0; j < recity[now.end].size(); j++) {
						recity[next.end].add(recity[now.end].get(j));
					}
					// 다음 좌표까지 update
					recity[next.end].add(next.end);
					// queue에 방문할 정점 추가
					queue.add(new node(next.end, recost[next.end]));
				}
			}
		}

		// 출력
		sb.append(recost[end]).append("\n").append(recity[end].size()).append("\n");
		for (int i = 0; i < recity[end].size(); i++) {
			sb.append(recity[end].get(i) + " ");
		}

		System.out.println(sb);
	}
}
