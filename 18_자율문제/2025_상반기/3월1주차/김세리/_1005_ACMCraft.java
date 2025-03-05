package _20250310;

import java.util.*;
import java.io.*;

public class _1005_ACMCraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] givenTimes = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				givenTimes[i] = Integer.parseInt(st.nextToken());
			}
			int[] indegree = new int[N+1];
			int[] usedTimes = new int[N+1];
			List<List<Integer>> graph = new ArrayList<>();
			List<List<Integer>> preNodes = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				graph.add(new ArrayList<>());
				preNodes.add(new ArrayList<>());
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph.get(X).add(Y);
				preNodes.get(Y).add(X);
				indegree[Y]++;
			}
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=N;i++) {
				if(indegree[i]==0) {
					q.add(i);
					usedTimes[i]=givenTimes[i];
				}
			}
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int next:graph.get(curr)) {
					indegree[next]--;
					if(indegree[next]==0) {
						int tmp=0;
						for(int prev:preNodes.get(next)) {
							tmp = Math.max(tmp,usedTimes[prev]);
						}
						usedTimes[next] = tmp+givenTimes[next];
						q.add(next);
					}
				}
			}
			int W = Integer.parseInt(br.readLine());
			System.out.println(usedTimes[W]);
			
			
		}
	}

}
