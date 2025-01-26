package _20250127;

import java.util.*;
import java.io.*;

public class _9470_Strahler순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			List<List<Integer>> graph = new ArrayList<>();
			for(int i=0;i<=M;i++) {
				graph.add(new ArrayList<>());
			}
			
			int[] indegree = new int[M+1];
			// 최대 Strahler 순서, 개수
			int[][] order = new int[M+1][2];
			
			for(int i=0;i<P;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				indegree[b]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=M;i++) {
				if(indegree[i]==0) {
					q.add(i);
					order[i][0]=1;
					order[i][1]=1;
				}
			}
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				for(int next:graph.get(curr)) {
					indegree[next]--;
					
					if(order[next][0]<order[curr][0]) {
						order[next][0]=order[curr][0];
						order[next][1]=1;
					}else if(order[next][0]==order[curr][0]) {
						order[next][1]++;
					}
					
					if(indegree[next]==0) {
						if(order[next][1]>=2) {
							order[next][0]++;
						}
						q.add(next);
					}
				}
			}
			
			System.out.println(tc+" "+order[M][0]);
		}
	}

}
