package _20241230;

import java.util.*;
import java.io.*;

public class _15681_트리와쿼리 {
	static int N, R, Q;
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] subtreeSize;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		subtreeSize = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			int queryNode = Integer.parseInt(br.readLine());
			sb.append(subtreeSize[queryNode]).append("\n");
		}
		System.out.print(sb);
		
	}
	
	private static int dfs(int currentNode) {
		visited[currentNode]=true;
		subtreeSize[currentNode]=1;
		
		for(int neighbor : tree.get(currentNode)) {
			if(!visited[neighbor]) {
				subtreeSize[currentNode] += dfs(neighbor);
			}
		}
		
		return subtreeSize[currentNode];
	}

}
