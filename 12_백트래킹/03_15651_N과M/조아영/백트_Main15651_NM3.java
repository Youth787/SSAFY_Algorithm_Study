import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백트_Main15651_NM3 {
	
	static int n, m; 
	static int[] result; 
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m];
		//1부터 n까지의 자연수 중에서 m개를 고른 수열 
		//같은 수 여러 번 골라도 됨 
		permutation(0); 
		System.out.println(sb);
		
	}
	
	static void permutation(int depth) { //중복순열 (dfs) 
		if (depth==m) {
//			for (int i : result) System.out.print(i+" "); //시간 초과 
//			System.out.println();
			for (int i : result) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<n; i++) {
			result[depth] = i+1; //해당 깊이를 index로 하여 i+1값 저장 
			permutation(depth+1); //다음 자식 노드 방문을 위해 depth+1 하고 재귀 호출
		}
	} //permutation

}
