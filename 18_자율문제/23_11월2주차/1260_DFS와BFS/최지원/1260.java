//package p1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb1;
	static StringBuilder sb2;
	static int n, m, v;
	static int [][] adjArr;
	static boolean [] visitedD;//DFS 방문처리
	static boolean [] visitedB;//BFS 방문처리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//정점의 개수
		m = Integer.parseInt(st.nextToken());//간선의 개수
		v = Integer.parseInt(st.nextToken());//시작 정점 번호
		
		adjArr = new int [n+1][n+1];//1번부터 간선 유무를 저장
		for (int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjArr [v1][v2] = adjArr [v2][v1] = 1;//간선은 양방향
		}//m개의 줄에 간선이 연결하는 두 정점의 번호
		
		visitedD = new boolean [n+1];
		visitedB = new boolean [n+1];
		
		DFS();
		BFS();
		
		System.out.println(sb1);
		System.out.println(sb2);
		
	}//main
	
	public static void DFS() {
		sb1 = new StringBuilder();
		Stack <Integer> stack = new Stack<>();//stack은 후입선출
		stack.add(v);
		while (!stack.isEmpty()) {
			int v3 = stack.pop();
			if (visitedD[v3]) continue;//안해주면 이미 돈 정점을 또 돈다
			else visitedD[v3] = true;//DFS에서는 stack에서 값을 pop했을 때 방문처리
			sb1.append(v3).append(' ');
			for (int i = n; i >= 1; i--) {
        //문제에서 "정점 번호가 작은 것을 먼저 방문"해야 한다고 했고,
        //stack은 후입선출 구조이기 때문에 i를 1부터 돌리게 되면 while문에서 번호가 큰 정점이 먼저 pop된다
				if (adjArr[v3][i] == 1 && !visitedD[i]) {
					stack.add(i);				
				}
			}
		}
		
	}//DFS
	
	public static void BFS() {
		sb2 = new StringBuilder();
		Queue <Integer> queue = new LinkedList<>();//queue는 선입선출
		queue.add(v);
		visitedB[v] = true;//BFS에서는 queue에 add할 때 방문처리
		sb2.append(v).append(' ');
		while (!queue.isEmpty()) {
			int v3 = queue.poll();
			for (int i = 1; i <= n; i++) {
				if (adjArr[v3][i] == 1 && !visitedB[i]) {
					queue.add(i);
					visitedB[i] = true;
					sb2.append(i).append(' ');
				}
			}
		}
	}//BFS

}//class
