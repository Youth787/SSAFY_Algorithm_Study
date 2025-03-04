package _20250310;

import java.util.*;
import java.io.*;

public class _2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		int[] depth = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			depth[b]++;
			graph.get(a).add(b);
		}
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			if(depth[i]==0) {
				q.add(i);
				visited[i]=true;
			}
		}
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for(int next: graph.get(curr)) {
				if(!visited[next]) {
					depth[next]--;
					if(depth[next]==0) {
						q.add(next);
						visited[next]=true;
					}
				}
			}
		}
		System.out.println(sb);
	}

}
