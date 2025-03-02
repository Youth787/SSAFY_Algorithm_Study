package _20250303;

import java.util.*;
import java.io.*;

public class _1916_최소비용구하기 {
	static int N, M;
	static List<List<int[]>> graph = new ArrayList<>();
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(A).add(new int[] {B,cost});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start,end));
		
	}
	static int dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		pq.add(new int[] {start,0});
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currCost = curr[1];
			
			if(currCost>dist[currNode]) continue;
			
			for(int[] next : graph.get(currNode)) {
				int nextNode = next[0];
				int nextCost = currCost + next[1];
				if(nextCost<dist[nextNode]) {
					dist[nextNode] = nextCost;
					pq.add(new int[] {nextNode, nextCost});
				}
			}
		}
		return dist[end];
		
	}

}
