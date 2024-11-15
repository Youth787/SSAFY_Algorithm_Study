package _20241119;

import java.util.*;
import java.io.*;

public class _2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		int[] inDegree = new int[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int prev= Integer.parseInt(st.nextToken());
			
			// 이전 수와 현재 수 를 graph에 저장
			for(int j=1;j<num;j++) {
				int curr = Integer.parseInt(st.nextToken());
				graph.get(prev).add(curr);
				// 현재 수의 관계 수를 카운트(언급 몇 번 되는지)
				// 진입 차수를 의미
				inDegree[curr]++;
				prev=curr;
			}
		}
		// 위상정렬
		List<Integer> result = topologicalSort(graph, inDegree,N);
		// 다 돌았음에도 result에 전부 추가되지 못했단 의미는 조건을 충족하는 결과가 없음을 의미.
		if(result.size() !=N) {
			System.out.println(0);
		} else {
			for(int singer:result) {
				System.out.println(singer);
			}
		}
		
	}
	
	private static List<Integer> topologicalSort(List<List<Integer>> graph, int[] inDegree, int N){
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			result.add(curr);
			
			for(int next : graph.get(curr)) {
				inDegree[next]--;
				// 어차피 진입 차수가 0이 되기 전까지는 진입할 수없음.
				// 그래서 이렇게 조건을 주어서 나중에 나오게 되더라도
				// 순서가 바뀌는 일은 없다.
				if(inDegree[next]==0) {
					queue.add(next);
				}
			}
		}
		return result;
	}

}
