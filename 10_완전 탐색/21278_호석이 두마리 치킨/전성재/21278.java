import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//플로이드 와샬 알고리즘 = a->c로 가는 값보다 b를 거쳐 a->b + b->c 값이 더 작다면 작은 값을 택하는 알고리즘.
//바로 위의 로직은 하나의 노드를 거쳐 가지만(a->b->c),
//해당 로직이 반복되면 수많은 노드를 거쳐도 (a->b->c->d->e)
//시작노드와 도착노드만 남게 된다 (a->e)

public class Main {
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				// 점의 최대 개수는 100개이므로, 점과 점은 아무리 멀어도 거리 99가 최대임.
				// 즉, 거리 101로 해주는 것은 다익스트라의 Integer.MAX_VALUE와 같음.
				map[i][j] = 101;
			}
		}

		// 간선 정보 입력 받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
		}

		// 플로이드 와샬 알고리즘
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

		int point1 = Integer.MAX_VALUE;
		int point2 = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// 2개의 지점을 치킨집으로 선정
				int dis = distance(i, j);
				// 더 작은 값을 찾으면 치킨집 장소와 최솟값 갱신
				if (min > dis) {
					point1 = i;
					point2 = j;
					min = dis;
				}
			}
		}

		// 왕복 거리이기 때문에 min*2 한 값을 출력
		System.out.println(point1 + " " + point2 + " " + min * 2);
	}

	/*
	 * 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 구하는 문제이기 때문에 두 치킨집 중 더 가까운 치킨집까지의 거리를 구해
	 * return 한다.
	 */
	static int distance(int x, int y) {
		int result = 0;
		for (int i = 1; i <= n; i++)
			result += Math.min(map[x][i], map[y][i]);

		return result;
	}
}
