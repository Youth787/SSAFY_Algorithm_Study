package _11월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS_1260 {
	static int N, M, S;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b][a] = arr[a][b] = 1;
		}
		
		visit = new boolean[N+1];
		
		DFS(S);
		System.out.println();
		visit = new boolean[N+1];
		BFS(S);
	}
	
	public static void DFS(int idx) {
		visit[idx] = true;
		System.out.print(idx+" ");
		
		for(int i=1; i<=N; i++) {
			if(arr[idx][i]==1 && !visit[i]) {
				DFS(i);
			}
		}
		return;
	}
	
	public static void BFS(int idx) {
		Queue<Integer>queue = new LinkedList<>();
		queue.add(idx);
		visit[idx] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			for(int i=1; i<=N; i++) {
				if(arr[curr][i]==1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}// for end 
		}// while end 
	}// bfs end
}
