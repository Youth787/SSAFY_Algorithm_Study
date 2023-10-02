package 백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 중복을 허용하는 순열 

public class n과m3 {
	static int N, M;
	static int[] result;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		DFS(0);
		
		bw.flush(); bw.close();
	}// main end

	public static void DFS(int depth) throws IOException {
		if (depth == M) {
			for (int a : result)
				bw.write(a + " ");
			bw.newLine();
			return;
		} // 기저파트 end

        // 순열 + 조합 이었던 1번문제에서 응용. 
        // boolean을 사용해 중복값을 피했던 1번 문제를 생각하면
        // boolean에 대한 부분을 지우면 중복을 허용해서 값을 출력할 것이라고 생각 가능. 
        
		for (int i = 0; i < N; i++) {
			result[depth] = i + 1;
			DFS(depth+1);
		}
	}// method end
}
