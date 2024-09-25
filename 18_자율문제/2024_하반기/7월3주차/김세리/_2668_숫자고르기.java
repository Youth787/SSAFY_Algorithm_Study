package _20240716;

import java.util.*;
import java.io.*;

public class _2668_숫자고르기 {
	
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;
	static List<Integer> result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		finished = new boolean[N+1];
		result = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) dfs(i);
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int num : result) {
			System.out.println(num);
		}
		
		sc.close();
	}//main
	
	static void dfs(int current) {
		visited[current] = true;
		int next = arr[current];
		
		// 다음 노드를 아직 방문하지 않았다면 dfs 재귀 호출
		if(!visited[next]) {
			dfs(next);
		}
		
		// 다음 노드를 이미 방문했고, 사이클 탐색이 완료되지 않았다면 사이클을 찾음
		else if(!finished[next]) {
			
			// 사이클을 이루는 노드를 결과 리스트에 추가
			for(int i=next; i!=current; i=arr[i]) {
				result.add(i);
			}
			result.add(current);
		}
		// 노드 탐색 완료 표시
		finished[current]=true;
	}

}
