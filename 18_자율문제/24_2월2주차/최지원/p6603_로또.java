package 백트래킹_p6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k; //몇개의 숫자를 고를지
	static int[] num; //고른 숫자들
	static boolean[] visited; //방문배열
	static int[] res; //결과
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			num = new int[k];
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			} //입력
				
			res = new int[6]; //6개 선택
			visited = new boolean[k]; //숫자 방문?
			backtracking(0, 0); //start = 0, depth = 0으로 시작
			
			System.out.println(sb);
		}
		
	} //main
	
	static void backtracking(int start, int depth) {
		if (depth == 6) {
			for (int n : res) {
				//가능한 경우 모두 출력해야 하니까
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		} //6개 고른 상황
		
		for (int i = start; i < k; i++) {
			if (!visited[i]) {
				//아직 사용 안한 숫자면
				visited[i] = true;
				res[depth] = num[i]; //depth번째 숫자 골랐다
				backtracking(i+1, depth +1); //그 자리에서 다음 숫자 찾으러 재귀
				
				visited[i] = false;
			}
		}
	} //backtracking

} //class
