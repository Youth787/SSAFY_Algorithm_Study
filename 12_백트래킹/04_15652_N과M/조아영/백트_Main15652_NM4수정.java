import java.util.Scanner;

public class 백트_Main15652_NM4수정 {
	
	static int n, m; 
	static int[] result; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		//1부터 n까지의 자연수 중에서 m개를 고른 수열 //중복 가능 //비내림차순(오름차순이거나 같거나)
		combi(0, 0); 
		
	}
	
	static void combi(int depth, int start) { //중복조합 (dfs) 
		if (depth==m) {
			for (int i : result) System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		for (int i=start; i<n; i++) {//NM1번에서 방문체크 빼고 i=start 시작으로 바꾸고 재귀 시작지점 i로 함 
			result[depth] = i+1; //해당 깊이를 index로 하여 i+1값 저장 
			combi(depth+1, i); //다음 자식 노드 방문을 위해 depth+1 하고 재귀 호출
		}
	} //combination

}
