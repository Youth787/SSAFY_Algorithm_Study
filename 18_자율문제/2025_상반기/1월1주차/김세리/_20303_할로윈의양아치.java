package _20250113;

import java.util.*;
import java.io.*;

public class _20303_할로윈의양아치 {
	static int N,M,K;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] candies;
	static boolean[] visited;
	static List<int[]> groups = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		candies = new int[N+1];
		visited = new boolean[N+1];
		
		st=new StringTokenizer(br.readLine());
		list.add(new ArrayList<>());
		for(int i=1;i<N+1;i++) {
			candies[i] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 친구 그룹 별로 친구 수 와 사탕 수 를 저장
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				int[] result = bfs(i);
				groups.add(result);
			}
		}
		
		int[] dp = new int[K+1];
		for(int[] group : groups) {
			int friCnt = group[0];
			int candyCnt = group[1];
			if(friCnt>K) continue;
			for(int j=K-1;j>=friCnt;j--) {
				if(j-friCnt>=0) {
					dp[j] = Math.max(dp[j],dp[j-friCnt]+candyCnt);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[K-1]);
	}
	static int[] bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		int friendsCount = 1;
		int candyCount = candies[start];
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int friend : list.get(curr)) {
				if(!visited[friend]) {
					visited[friend]=true;
					q.add(friend);
					friendsCount++;
					candyCount += candies[friend];
				}
			}
		}
		return new int[] {friendsCount, candyCount};
	}

}
