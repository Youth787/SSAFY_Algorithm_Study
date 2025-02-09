//프로그래머스 석유 시추 자바
// bfs, map, 구현

import java.util.*;

public class Solution {
	int N, M;
	int[][] visit, arr;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	Map<Integer, Integer> map = new HashMap<>();

	public int solution(int[][] land) {
		N = land.length;
		M = land[0].length;
		visit = new int[N][M];
		arr = land;

		int groupId = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] == 1 && visit[i][j] == 0) {
					groupId++;
					search(i, j, groupId);
				}
			}
		}

		int answer = 0;
		for (int j = 0; j < M; ++j) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < N; ++i) {
				if (visit[i][j] != 0)
					set.add(visit[i][j]);
			}
			int sum = 0;
			for (int value : set) {
				sum += map.get(value);
			}
			answer = Math.max(answer, sum);
		}

		return answer;
	}

	private void search(int x, int y, int groupId) {
		visit[x][y] = groupId;

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});

		int count = 1;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int d = 0; d < 4; ++d) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if (!isInRange(nx, ny)) // 범위 밖은 탐색하지 않는다.
					continue;
				if (visit[nx][ny] != 0) // 이미 탐색된 부분은 탐색하지 않는다.
					continue;
				if (arr[x][y] != arr[nx][ny]) // 석유가 없는 자리는 탐색하지 않는다.
					continue;
				visit[nx][ny] = groupId;
				q.add(new int[] {nx, ny});
				count++;
			}
		}
		map.put(groupId, count);
	}

	public boolean isInRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M)
			return true;
		return false;
	}
}
