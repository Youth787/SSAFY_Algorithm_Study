import java.util.*;

public class Main21736_헌내기친구필요 {

	static int[] dr = {0,0,1,-1}; //동서남북
	static int[] dc = {1,-1,0,0};
	static char[][] arr;
	static boolean[][] visited;
	static int n, m, ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int stR = 0, stC = 0;
		
		arr = new char[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			String temp = new String(sc.next());
			for (int j=0; j<m; j++) {
				arr[i][j] = temp.charAt(j);
				if (arr[i][j]=='I') {
					stR = i;
					stC = j;
				}
			}
//			System.out.println(Arrays.toString(arr[i]));
		}
		
		ans = 0;
		dfs(stR, stC);
		
		System.out.println(ans==0? "TT" : ans);
		
	}
	
	static void dfs(int r, int c) { //dfs야...?? 
		
//		System.out.println(r+" "+c);
		
		if (arr[r][c]=='X') return; //벽이면 리턴 
		if (arr[r][c]=='P') ans++;
		
		int newR = 0;
		int newC = 0;
		
		for (int i=0; i<4; i++) {
			visited[r][c] = true; 
			newR = r + dr[i];
			newC = c + dc[i];
//			System.out.println(newR+" "+newC);
			if (newR<0 || newR>=n || newC<0 || newC>=m || visited[newR][newC]) continue;
			dfs(newR, newC);
//			visited[r][c] = false; 
		}
	
	}
	
}
