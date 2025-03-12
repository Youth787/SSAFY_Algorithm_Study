package _20250310;

import java.util.*;
import java.io.*;

public class _test1 {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] times,ans,indegree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		times=new int[N+1];
		indegree=new int[N+1];
		ans=new int[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			times[i]=a;
			while(a!=-1) {
				a = Integer.parseInt(st.nextToken());
				if(a==-1) break;
				graph.get(a).add(i);
				indegree[i]++;
			}
		}
//		System.out.println(graph);
//		System.out.println(Arrays.toString(times));
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
				ans[i]=times[i];
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next: graph.get(curr)) {
				ans[next] =Math.max(ans[curr]+times[next],ans[next]);
				indegree[next]--;
				if(indegree[next]==0) {
//					System.out.println(next);
					q.add(next);
//					System.out.println(Arrays.toString(ans));
				}
				
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(ans[i]);
		}
		
	}

}
