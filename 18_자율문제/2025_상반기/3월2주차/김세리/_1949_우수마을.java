package _20250317;

import java.util.*;
import java.io.*;

public class _1949_우수마을 {
	static int N;
	static int[] population;
	static int[][] dp;
	static boolean[] visited;
	static List<List<Integer>> tree = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=N;i++) {
			tree.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		dfs(1);
		// 우수 마을을 선택하는 경우와 그렇지 않은 경우 중 큰 것을 출력
		System.out.println(Math.max(dp[1][0],dp[1][1]));
	}
	static void dfs(int node) {
		visited[node]=true;
		// 우수마을로 선택한 경우
		dp[node][1] = population[node];
		
		for(int child:tree.get(node)) {
			if(!visited[child]) {
				dfs(child);
				
				dp[node][0] += Math.max(dp[child][0],dp[child][1]);
				dp[node][1] += dp[child][0];
			}
		}
	}

}
