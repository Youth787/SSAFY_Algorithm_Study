package _20250106;

import java.util.*;
import java.io.*;

public class _13023_ABCDE {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int N,M;
	static boolean found;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited = new boolean[N];
		found = false;
		for(int i=0;i<N;i++) {
			Arrays.fill(visited, false);
			dfs(i,1);
			if(found) break;
		}
		System.out.println(found ? 1:0);
	}
	private static void dfs(int node, int depth) {
		if(found) return;
		if(depth == 5) {
			found = true;
			return;
		}
		
		visited[node]=true;
		
		for(int neighbor : graph.get(node)) {
			if(!visited[neighbor]) {
				dfs(neighbor,depth+1);
			}
		}
		visited[node] =false;
	}

}
