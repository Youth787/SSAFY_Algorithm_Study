import java.util.Arrays;
import java.util.Scanner;

public class 백트_Main15654_NM5수정 {
	
	static int n, m; 
	static int[] arr; 
	static int[] result; 
	static boolean[] visited; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		result = new int[m];
		visited = new boolean[n]; 
		//n개의 자연수 중에서 m개를 고른 수열 
		Arrays.sort(arr);
		permutation(0); 
		
	}
	
	static void permutation(int depth) { //순열 (dfs) 
		if (depth==m) {
			for (int i : result) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true; 
				result[depth] = arr[i]; //해당 깊이를 index로 하여 i+1값 저장 
				permutation(depth+1); //다음 자식 노드 방문을 위해 depth+1 하고 재귀 호출
				visited[i] = false;
			}
		}
	} //permutation

}
