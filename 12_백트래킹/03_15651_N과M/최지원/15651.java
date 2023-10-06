
import java.util.Scanner;
//중복 없는 조합
public class Main {
	
	public static int[] arr;
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		n = sc.nextInt();
		m = sc.nextInt();
 
		arr = new int[m];
        
		DFS(0);
		System.out.print(sb);
 
	}
 
	public static void DFS(int depth) {
		//기저조건 m에 도달 ?: 출력후 return
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= n; i++) {
			arr[depth] = i;
			DFS(depth + 1);
		}
	}
 
}
