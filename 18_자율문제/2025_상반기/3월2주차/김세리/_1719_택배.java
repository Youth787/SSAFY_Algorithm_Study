package _20250317;

import java.util.*;
import java.io.*;

public class _1719_택배 {
	static int N,M;
	static class Node implements Comparable<Node>{
		int num;
		int time;
		public Node(int num, int time) {
			this.num=num;
			this.time=time;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time,o.time);
		}
	}
	static List<List<Node>> graph = new ArrayList<>();
	static int[][] route;
	
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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b,time));
			graph.get(b).add(new Node(a,time));
		}
		route = new int[N+1][N+1];
		
		for(int start=1;start<=N;start++) {
			dijkstra(start);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) {
					sb.append("- ");
				} else {
					sb.append(route[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[start]=0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currNum = curr.num;
			int currTime = curr.time;
			
			if(currTime>dist[currNum]) continue;
			
			for(Node next:graph.get(currNum)) {
				int newDist = currTime+next.time;
				if(newDist < dist[next.num]) {
					dist[next.num] = newDist;
					pq.add(new Node(next.num,newDist));
					
					if(currNum==start) {
						route[start][next.num] = next.num;
					} else {
						route[start][next.num] = route[start][currNum];
					}
				}
			}
		}
		
	}

}
