import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2644 {

	static int n, start, end, ans;
	static boolean [][] adjArr;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		n = Integer.parseInt(br.readLine());//사람 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		ans = -1;//촌수 계산 불가 시 -1
		
		adjArr = new boolean [n+1][n+1];
		int m = Integer.parseInt(br.readLine());//관계수(간선)
		for (int i = 0; i < m; i++) {//입력 관계 수만큼
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());//정점1
			int v2 = Integer.parseInt(st.nextToken());//2
			
			adjArr [v1][v2] = adjArr [v2][v1] = true;//양방향
		}
		
		visited = new boolean [n+1];
		DFS(start, 0);//시작점과 관계수 카운트(0부터)
		
		System.out.println(ans);
	}//main

	public static void DFS(int a, int b) {
		visited [a] = true;
		if(a == end) {
			ans = b;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(adjArr[a][i] && !visited[i]) DFS(i, b+1);
		}
	}//DFS
	
}//class
