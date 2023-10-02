package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복을 허용하는 조합 

public class n과m4 {
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];

		DFS(0,1);
	}// main end

	public static void DFS(int depth, int idx) {
		if(depth==M) {
			for(int a : result) 
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			result[depth] = i;
			DFS(depth+1, i);
		}
	}
}
