package _20241223;

import java.util.*;
import java.io.*;

public class _1753_최단경로 {
	static class Node implements Comparable<Node>{
		int v,w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w); // 가중치 기준 오름차순 정렬
		}
	}
	
	static int V,E,K;
	static List<List<Node>> graph;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i=0;i<=V;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v,w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currV = current.v;
			int currW = current.w;
			
			if(currW > dist[currV]) continue;
			
			for(Node neighbor : graph.get(currV)) {
				if(dist[neighbor.v]>dist[currV]+neighbor.w) {
					dist[neighbor.v] = dist[currV]+neighbor.w;
					pq.add(new Node(neighbor.v, dist[neighbor.v]));
				}
			}
		}
	}

}
