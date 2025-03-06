package _20250310;

import java.util.*;
import java.io.*;

public class _2637_장남감조립 {
	static int[][] map;
	static int[] ans, indegree;
	static boolean[] isMid;
	static List<List<Integer>> graph = new ArrayList<>();;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		map = new int[N+1][N+1];
		ans = new int[N+1];
		indegree = new int[N+1];
		isMid = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			graph.get(X).add(Y);
			map[X][Y]=K;
			indegree[Y]++;
			isMid[X]=true;
		}
		
		solve(N);
		for(int i=1;i<=N;i++) {
			if(!isMid[i]) {
				System.out.println(i+" "+ans[i]);				
			}
		}
		
		
	}
	static void solve(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		ans[N]=1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next:graph.get(curr)) {
				ans[next] += ans[curr]*map[curr][next];
				indegree[next]--;
				if(indegree[next]==0) {
					q.add(next);
				}
			}
		}
	}

}
