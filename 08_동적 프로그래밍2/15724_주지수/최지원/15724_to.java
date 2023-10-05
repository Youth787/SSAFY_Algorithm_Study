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
		int [][] p = new int [n+1][m+1];//좌표를 있는 그대로 받아들일라고
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 완
		
		StringBuilder sb = new StringBuilder();
		
		int k =  Integer.parseInt(br.readLine());//궁금한 직사각형 범위 수(k번 수행)
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					sum += p[x][y];
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
