import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class bj1915 {

	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		//입력 끝
		
		// (0, 0)부터 (i, j)까지의 부분 합
		int[][] psum = new int[n + 1][m + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + map[i][j];
				}
			}
				
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1) {
					int res = 1;
					int idx = 1;
					
					while (i + idx <= n && j + idx <= m) {
						int space = psum[i + idx][j + idx] - psum[i + idx][j - 1] - psum[i - 1][j + idx] + psum[i - 1][j - 1];
						idx++;
						if (space != idx * idx) break;
						res = idx * idx;
					}
					ans = Math.max(ans, res);
				}
			}
		}
 		
		
		System.out.println(ans);
		
	}

}

//https://steady-coding.tistory.com/151
