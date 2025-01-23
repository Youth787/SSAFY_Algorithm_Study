package _20250127;

import java.util.*;
import java.io.*;

public class _1504_특정한최단경로 {
	static int N, E;
	static final int INF = 200000000; // 충분히 큰 값
	static ArrayList<ArrayList<Node>> graph;
	static class Node implements Comparable<Node>{
		int idx;
		int distance;
		
		public Node(int idx, int distance) {
			this.idx=idx;
			this.distance=distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance,o.distance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 → v1 → v2 → N 경로와 1 → v2 → v1 → N 경로 중 최소값 찾기
        long path1 = 0, path2 = 0;
        
        path1 += dijkstra(1,v1);
        path1 += dijkstra(v1,v2);
        path1 += dijkstra(v2,N);
		
        path2 += dijkstra(1,v2);
        path2 += dijkstra(v2,v1);
        path2 += dijkstra(v1,N);
        
        long result = Math.min(path1,path2);
        
        if(result>=INF) {
        	System.out.println(-1);        	
        } else {
        	System.out.println(result);
        }
        
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int now = current.idx;
			int distance = current.distance;
			
			if(dist[now]<distance) continue;
			
			for(Node next : graph.get(now)) {
				int cost = dist[now] + next.distance;
				if(cost<dist[next.idx]) {
					dist[next.idx]=cost;
					pq.offer(new Node(next.idx,cost));
				}
			}
		}
		return dist[end];
		
	}

}
