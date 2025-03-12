package _20250317;

import java.util.*;
import java.io.*;

public class _2211_네트워크복구 {
	static int N,M;
	static List<List<Node>> graph = new ArrayList<>();
	static int[] dist, prev;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx,int cost) {
			this.idx=idx;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost,o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Node(B,C));
			graph.get(B).add(new Node(A,C));
		}
		
		dijkstra(1);
		
		List<int[]> result = new ArrayList<>();
		for(int i=2;i<=N;i++) {
			if(prev[i]!=0) {
				result.add(new int[] {prev[i],i});
			}
		}
		
		System.out.println(result.size());
		for(int[] connection:result) {
			System.out.println(connection[0]+" "+connection[1]);
		}
		
	}//main
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N+1];
		prev = new int[N+1];
		
		Arrays.fill(dist,INF);
		dist[start]=0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currIdx = curr.idx;
			int currCost = curr.cost;
			if(currCost>dist[currIdx]) continue;
			
			for(Node next:graph.get(currIdx)) {
				int newCost = currCost + next.cost;
				
				if(newCost < dist[next.idx]) {
					dist[next.idx] = newCost;
					prev[next.idx] = currIdx; // 이전 노드 저장(복구 경로)
					pq.add(new Node(next.idx, newCost));
				}
			}
		}
	}

}
