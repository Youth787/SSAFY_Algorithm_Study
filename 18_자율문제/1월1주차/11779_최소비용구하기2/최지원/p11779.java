/*
 * n개의 도시 중 한 곳에서 출발해서 다른 도시에 도착하는 m개의 버스
 * a번째 도시에서 b번째 도시까지 가는데 드는 최소 비용과 경로 출력
 * 
 * 입력: 첫줄에 도시개수 n, 둘째 줄에 버스개수 m, 버스 정보(출발지번호, 도착지번호, 비용), m+3번째 줄에 출발지번호와 도착지번호
 * 
 * 출력: 최소비용\n 경로에 포함된 도시 개수\n 방문 순 경로 
 * 
 * https://velog.io/@bobae1998/%EB%B0%B1%EC%A4%80-11779-%EC%B5%9C%EC%86%8C%EB%B9%84%EC%9A%A9-%EA%B5%AC%ED%95%98%EA%B8%B02-JAVA
 * 어렵따...복짭하다...
 */

import java.io.*;
import java.util.*;

public class Main {
	static class City implements Comparable<City> {
		int to;
		int cost;

		public City(int to, int cost) {
			this.to = to; // 도착 도시
			this.cost = cost; // 비용
		}

		@Override
		public int compareTo(City o) { // cost에 따라 오름차순으로 정렬되도록 설정
			return this.cost - o.cost;
		}
	}

	static int N, M; // 도시 수 N, 버스 수 M
	static int dist[], preCity[]; // d[]는 최단 거리를 저장하는 배열, preCity[]는 이전 도시를 저장하는 배열
	static int start, end; // 출발 도시 start, 도착 도시 end
	static List<ArrayList<City>> graph; // 각 도시에 연결된 도시와 비용을 저장할 그래프

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 도시의 수 입력
		M = Integer.parseInt(br.readLine()); // 버스의 수 입력

		dist = new int[N + 1]; // 각 도시까지의 최단 거리를 저장할 배열
		preCity = new int[N + 1]; // 각 도시까지 오기 직전에 거친 도시를 저장할 배열
		Arrays.fill(d, Integer.MAX_VALUE); // 최단 거리 배열을 무한대로 초기화

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<City>()); // 그래프 초기화

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new City(to, cost)); // 버스 정보를 그래프에 추가

		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		end = Integer.parseInt(st.nextToken()); // 도착 도시 번호

		dijkstra(start); // 다익스트라 알고리즘 실행
		System.out.println(dist[end]); // 최단 거리 출력

		// 경로 역추적
		int cnt = 0; // 경로에 포함된 도시의 수
		Stack<Integer> stack = new Stack<>(); // 경로를 담을 스택
		stack.push(end); // 목적지부터 시작하여 역순으로 경로를 스택에 저장
		while (preCity[end] != 0) { // 시작 도시에 도달할 때까지 반복
			cnt += 1;
			stack.push(preCity[end]);
			end = preCity[end];
		}
		System.out.println(cnt + 1); // 경로에 포함된 도시의 수 출력
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " "); // 경로 출력
		}

	}

	static void dijkstra(int start) { //다익스트라
		PriorityQueue <City> pq = new PriorityQueue <City>(); // 우선순위 큐 사용
		pq.add(new City(start, 0)); // 시작점을 우선순위 큐에 삽입
		dist[start] = 0; // 시작 도시까지의 최단 거리는 0

		while (!pq.isEmpty()) { // 큐가 비어있지 않는 동안 반복
			City curCity = pq.poll(); // 현재 도시
			int cur = curCity.to;
			if (dist[cur] < curCity.cost) // 현재 도시까지의 거리가 이미 알려진 최단 거리보다 크면 무시
				continue;
			for (City next : graph.get(cur)) { // 현재 도시와 연결된 모든 도시에 대해 반복
				if (dist[next.to] > dist[cur] + next.cost) { // 최단거리 업데이트 가능하면
					dist[next.to] = dist[cur] + next.cost; // 최단거리 업데이트
					preCity[next.to] = cur; // 이전 도시 기록
					pq.offer(new City(next.to, dist[next.to])); // 우선순위 큐에 추가
				}
			}
		}

	}
}
