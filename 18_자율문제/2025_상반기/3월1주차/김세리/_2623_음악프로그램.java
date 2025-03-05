package _20250310;

import java.util.*;
import java.io.*;

public class _2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] depth = new int[N+1];
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j=0;j<num-1;j++) {
				int curr = Integer.parseInt(st.nextToken());
				depth[curr]++;
				graph.get(prev).add(curr);
				prev = curr;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(depth[i]==0) {
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			cnt++;
			sb.append(curr).append("\n");
			for(int next : graph.get(curr)) {
				depth[next]--;
				if(depth[next]==0) {
					q.add(next);
				}
			}
		}
		if(cnt!=N) System.out.println(0);
		else System.out.println(sb);
	}

}
