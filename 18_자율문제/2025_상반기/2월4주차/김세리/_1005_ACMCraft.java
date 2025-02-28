package _20250303;

import java.util.*;
import java.io.*;

public class _1005_ACMCraft {
	static int N,K;
	static int[] times, dp, indegree;
	static List<List<Integer>> graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			times = new int[N+1];
			dp = new int[N+1];
			indegree = new int[N+1];
			graph = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				graph.get(X).add(Y);
				indegree[Y]++;
			}
			int last = Integer.parseInt(br.readLine());
			System.out.println(topologicalSort(last));
		}
	}
	
	static int topologicalSort(int last) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
				dp[i] = times[i];
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next : graph.get(curr)) {
				dp[next] = Math.max(dp[next],dp[curr]+times[next]);
				indegree[next]--;
				if(indegree[next]==0) {
					q.add(next);
				}
			}
		}
		return dp[last];
	}

}
