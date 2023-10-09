import java.util.Scanner;

public class 백트_Main15650_NM2수정 {
	
	static int n, m; 
	static int[] result; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		//1부터 n까지의 자연수 중에서 중복 없이 m개를 고른 수열 & 오름차순이어야 함 -> 조합 
		nCr(0, 0); 
		
	}
	
	static void nCr(int depth, int start) { //조합(Combination) (dfs) 
		if (depth==m) {
			for (int i : result) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=start; i<n; i++) { //NM1번에서 방문체크 빼고 i=start 시작으로 바꿈 
			result[depth] = i+1; //해당 깊이를 index로 하여 i+1값 저장 
			nCr(depth+1, i+1); //다음 자식 노드 방문을 위해 depth+1 하고 재귀 호출
		}
	} //nCr

}
