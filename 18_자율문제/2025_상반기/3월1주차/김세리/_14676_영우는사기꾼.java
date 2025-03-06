package _20250310;

import java.util.*;
import java.io.*;

public class _14676_영우는사기꾼 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int[N+1];
		int[] buildings = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			graph.get(X).add(Y);
			indegree[Y]++;
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			if(dir==1) {
				if(indegree[a]>0) {
					System.out.println("Lier!");
					return;
				}
				buildings[a]++;
				if(buildings[a]==1) {
					for(int next:graph.get(a)) {
						indegree[next]--;
					}
				}
				
			} else {
				if(buildings[a]==0) {
					System.out.println("Lier!");
					return;
				}
				buildings[a]--;
				if(buildings[a]==0) {
					for(int next:graph.get(a)) {
						indegree[next]++;
					}
				}
			}
		}
		System.out.println("King-God-Emperor");
		
		
	}

}
