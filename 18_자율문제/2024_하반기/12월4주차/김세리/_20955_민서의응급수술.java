package _20241230;

import java.util.*;
import java.io.*;

public class _20955_민서의응급수술 {
	static int N, M;
	static List<List<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=N;i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		visited = new boolean[N+1];
		int cycleCount = 0; // 사이클 제거 횟수
		int componentCount = 0; // 연결 컴포넌트 개수
		
		// 모든 노드를 탐색하여 사이클 제거 및 연결 컴포넌트 개수 확인
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				componentCount++;
				cycleCount += dfs(i,-1); // DFS를 통해 사이클 제거
			}
		}
		
		// 사이클에서 간선 하나만 제거하도록 조정
        cycleCount /= 2;
        
		// 작업 횟수 = 사이클 제거 횟수 + 연결 작업 횟수
		int result = cycleCount + (componentCount-1);
		System.out.println(result);
	}
	
	private static int dfs(int node, int parent) {
		visited[node] = true;
		int cycles=0;
		
		for(int neighbor : tree.get(node)) {
			if(!visited[neighbor]) {
				// 방문하지 않은 노드라면 DFS 탐색
				cycles += dfs(neighbor, node);
			} else if(neighbor != parent) {
				// 이미 방문한 노드인데 부모 노드가 아니라면 사이클 발견
				cycles++;
			}
		}
		return cycles;
	}

}
