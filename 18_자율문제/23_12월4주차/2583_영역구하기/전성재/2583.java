import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int m, n, k, cnt;
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
		
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			
			for(int j = a2; j < b2; j++) {
				for(int t = a1; t < b1; t++) {
					map[j][t] = 1;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		
		for(int i : list) {
			System.out.print(i + " ");
		}
		
	}
	
	static void dfs(int x, int y) {
		map[x][y] = 1;
		cnt++;
		
		for(int k = 0; k < 4; k++) {
			int r = x + dx[k];
			int c = y + dy[k];
			
			if(r >= 0 && c >= 0 && r < m && c < n) {
				if(map[r][c] == 0) {
					dfs(r, c);
				}
			}
		}
	}
}
