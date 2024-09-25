package p15724_주지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] popu = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				popu[i][j] = Integer.parseInt(st.nextToken()) + popu[i-1][j] + popu[i][j-1] - popu[i-1][j-1];
			}				
		} //인구 수 저장 시 미리 누적합 popu[i][j] = 새로 입력받은 값 + popu[i-1][j] + popu[i][j-1] - popu[i-1][j-1]
		
		int k = Integer.parseInt(br.readLine()); //경우
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int sR = Integer.parseInt(st.nextToken());
			int sC = Integer.parseInt(st.nextToken());
			int eR = Integer.parseInt(st.nextToken());
			int eC = Integer.parseInt(st.nextToken());
			int sum = popu[eR][eC] - popu[eR][sC-1] - popu[sR-1][eC] + popu[sR-1][sC-1];				
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);

	} //main
} //class

