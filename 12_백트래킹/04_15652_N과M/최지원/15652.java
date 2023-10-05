
import java.util.Scanner;

public class Main {
 
	public static int n, m;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
 
		DFS(1, 0);
		System.out.println(sb);
 
	}
 
	public static void DFS(int st, int depth) {
 
		if (depth == m) {
			for (int nn : arr) {
				sb.append(nn).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = st; i <= n; i++) {
			arr[depth] = i;
			DFS(i, depth + 1);
		}
 
	}
 
}
