package p15649_n과m;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[m];
		visited = new boolean[n];
		
		powerset(n,m,0);
		System.out.println(sb);
	}
	
	static void powerset(int n, int m, int depth) {
		if (depth == m) {
			for ( int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				powerset(n, m, depth+1);
				visited[i] = false;
			}
		}
	}
} //class
