package _20250210;

import java.util.*;
import java.io.*;

public class _1939_중량제한 {
	static int N,M,ans;
	static List<List<Node>> graph = new ArrayList<>();
	static boolean[] visited;
	static class Node{
		int to, weight;
		public Node(int to, int weight) {
			this.to=to;
			this.weight=weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
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
		
		st = new StringTokenizer(br.readLine());
		int islandA = Integer.parseInt(st.nextToken());
		int islandB = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(islandA,islandB));
	}
	
	static int bfs(int start, int destination) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(b.weight,a.weight));
		visited = new boolean[N+1];
		pq.add(new Node(start,Integer.MAX_VALUE));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int node = curr.to;
			int weight = curr.weight;
			
			if(node==destination) {
				return weight;
			}
			if(visited[node]) continue;
			visited[node] = true;
			
			for(Node next : graph.get(node)) {
				if(!visited[next.to]) {
					pq.add(new Node(next.to, Math.min(weight,next.weight)));
				}
			}
		}
		return 0;
	}

}
