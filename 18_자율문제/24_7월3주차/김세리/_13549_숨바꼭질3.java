package _20240716;

import java.util.*;
import java.io.*;

public class _13549_숨바꼭질3 {
	static int N, K;
	static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited=new int[100001];
		Arrays.fill(visited, -1);
		
		int answer = bfs(N,K);
		
		System.out.println(answer);
		
		sc.close();
	}//main
	
	static int bfs (int start, int target) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {start,0});
		visited[start]=0;
		
		while(!deque.isEmpty()) {
			int[] current = deque.poll();
			int position = current[0];
			int time = current[1];
//			System.out.println("position: "+position+", time: "+ time);
			if(position==target) {
				return time;
			}
			
			// 순간이동
			if(position *2 <=100000 && (visited[position*2]==-1 || visited[position*2] > time)) {
				visited[position*2]=time;
				deque.addFirst(new int[] {position*2,time});
			}
			
			// 앞으로 한 칸 이동
			if(position+1<=100000 && (visited[position+1]==-1 || visited[position+1] > time+1)) {
				visited[position+1]=time+1;
				deque.addLast(new int[] {position+1,time+1});
			}
			
			// 뒤로 한 칸 이동
			if(position-1>=0 && (visited[position-1]==-1 || visited[position-1] > time+1)) {
				visited[position-1]=time+1;
				deque.addLast(new int[] {position-1,time+1});
			}
		}
		// 타겟에 도달하지 못한 경우. 논리적으론 이 코드에 도달하지 않음.
		return -1;
	} // bfs
}
