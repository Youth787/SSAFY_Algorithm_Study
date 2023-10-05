
import java.util.Scanner;

public class Main {
 
	static int[] arr;
	static boolean[] visited;//방문?
	static StringBuilder sb = new StringBuilder();	//DFS에서 사용해줄꺼임
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
 
		arr = new int[m];
		visited = new boolean[n];
		
		DFS(n, m, 0);

		System.out.println(sb);
 
	}
 
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
