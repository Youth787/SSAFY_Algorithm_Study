/*
문제 : 자연수 n과 m이 주어졌을 때, 1부터 n까지 자연수 중 중복없이 m개를 고른 수열을 모두 구함
*/
import java.util.Scanner;

public class Main {
 
	static int[] arr;
	static boolean[] visited;//방문
	static StringBuilder sb = new StringBuilder();	//DFS에서 사용해줄꺼임
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();//자연수 n
		int m = sc.nextInt();//몇개 뽑을지
 
		arr = new int[m];//뽑은 수를 저장하는 int 배열
		visited = new boolean[n];//1~n까지의 수에서 그 수를 뽑았는지 확인하는 방문처리 boolean 배열
		
		DFS(n, m, 0); 

		System.out.println(sb);
 
	}

	//인자를 n, m, depth
	public static void DFS(int N, int M, int depth) {
		//기저조건 M에 도달 ?: 출력후 return
		if (depth == M) {
			for (int nn : arr) {
				sb.append(nn).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				DFS(N, M, depth + 1);
				visited[i] = false;
			}
		}
	}
 
}
