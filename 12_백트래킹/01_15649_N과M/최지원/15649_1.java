package N과M;

import java.util.Scanner;

public class s1 {
	
	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int n = sc.nextInt();//자연수 n
		int m = sc.nextInt();//1부터 n까지의 자연수 중에 몇 개 뽑을지
		
		arr = new int [m]; //뽑은 수 저장하는 곳
		visited = new boolean [n+1];//중복해서 뽑을 수 없기 때문에 방문처리 배열
		
		DFS(n, m, 0); //n, m 가져가고, 0은 m개 중 몇 개까지 뽑은 상태인지 저장
		
		System.out.println(sb);
		
	}//main

	private static void DFS(int n, int m, int depth) {
		//기저 조건 : m개 다 뽑았음?
		if ( m == depth ) {
			for (int i = 0; i< m; i++) sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		//재귀 조건 : n개의 수를 다 돌면서 방문 안했으면 방문하거나, 철수하고 패스하는 작업
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				DFS(n, m, depth+1); // i를 수열에 넣겠다
				visited[i] = false; //철수
			}
		}
	}
}//class
