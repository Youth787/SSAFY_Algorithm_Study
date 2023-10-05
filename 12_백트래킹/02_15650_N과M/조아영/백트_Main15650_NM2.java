import java.util.Scanner;

public class 백트_Main15650_NM2 {
	
	static int n, m; 
	static int[] result; 
	static boolean[] visited; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		visited = new boolean[n]; 
		//1부터 n까지의 자연수 중에서 중복 없이 m개를 고른 수열
		//오름차순이어야 함
		permutation(0, 0); 
		
	}
	
	static void permutation(int depth, int start) { //오름차순 순열 (dfs) 
		if (depth==m) {
			for (int i : result) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=start; i<n; i++) {
			if (!visited[i]) { //해당 노드를 방문하지 않았다면  
				visited[i] = true; //해당 노드 방문상태 변경하여 사용했다고 표시 
				result[depth] = i+1; //해당 깊이를 index로 하여 i+1값 저장 
				permutation(depth+1, i+1); //다음 자식 노드 방문을 위해 depth+1 하고 재귀 호출
				visited[i] = false; //자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경 
			}
		}
	} //permutation

}
