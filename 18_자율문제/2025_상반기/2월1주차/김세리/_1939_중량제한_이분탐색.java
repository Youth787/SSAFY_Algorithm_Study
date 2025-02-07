package _20250210;

import java.util.*;
import java.io.*;

public class _1939_중량제한_이분탐색 {
	static int N,M,start,end;
	static List<List<Node>> graph = new ArrayList<>();
	
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
		
		int maxWeight=0;

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.get(A).add(new Node(B,C));
			graph.get(B).add(new Node(A,C));
			maxWeight = Math.max(maxWeight,C);
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(binarySearch(1,maxWeight));
	}
	static int binarySearch(int left, int right) {
		int result=0;
		while(left<=right) {
			int mid = (left+right)/2;
			if(bfs(mid)) {
				result=mid;
				left=mid+1;
			} else {
				right = mid-1;
			}
		}
		return result;
	}
	
	static boolean bfs(int limit) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == end) return true;
			for(Node next : graph.get(curr)) {
				if(!visited[next.to] && next.weight>=limit) {
					visited[next.to] = true;
					q.add(next.to);
				}
			}
		}
		return false;
	}
}
