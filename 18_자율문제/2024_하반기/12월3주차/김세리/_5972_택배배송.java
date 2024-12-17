package _20241223;

import java.util.*;
import java.io.*;

public class _5972_택배배송 {
	static class Node implements Comparable<Node> {
		// implements Comparable<Node>를 사용하는 이유
		// -> 문제 풀이할 때 PriorityQueue나 Arrays.sort()에서 정렬 기준을 사용자가 정의하기 위해서
		
		int vertex, cost;
		Node(int vertex, int cost){
			this.vertex = vertex; // 노드 번호
			this.cost = cost; // 해당 노드까지의 비용
		}
		
		@Override
		public int compareTo(Node o) {
			// this.cost = 현재 노드의 비용
			// o.cost = 비교할 다른 노드의 비용
			return Integer.compare(this.cost, o.cost); // 최소 비용 우선
		}
	}
	
	private static int N, M;
	private static List<List<Node>> graph;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		
		graph = new ArrayList<>();
		// 그래프 초기화
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b,cost));
			graph.get(b).add(new Node(a,cost));
		}
		// 출발 노드에서 다른 모든 노드까지의 최단거리 저장
		dist = new int[N+1];
		// 처음에 무한대로 설정
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra(1);

		System.out.println(dist[N]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			// 현재 비용이 가장 작은 노드를 꺼낸다
			Node current = pq.poll();
			// 현재 비용 > 기존 비용 일 경우 무시한다(원래 다른 방법이 더 적게 소요되니까)
			if(current.cost > dist[current.vertex]) {
				continue;
			}
			// 현재 노드와 연결된 모든 노드를 탐색한다
			for(Node next : graph.get(current.vertex)) {
				// 더 짧은 경로를 탐색한 경우
				if(dist[next.vertex] > dist[current.vertex] + next.cost) {
					// 더 짧은 경로로 dist를 업데이트 해준다
					dist[next.vertex] = dist[current.vertex] + next.cost;
					// 업데이트한 노드를 피큐에 추가한다
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}


}
