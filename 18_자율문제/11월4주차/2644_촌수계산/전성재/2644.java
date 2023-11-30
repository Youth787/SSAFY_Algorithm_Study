import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS
public class Main{

	static int N, from, to, result=-1; // result를 -1로 초기화!
	static boolean[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 사람의 수
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) { // 관계 개수만큼만 돌기!
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());//부모
			int v2 = Integer.parseInt(st.nextToken());//자식
			
			map[v1][v2]=map[v2][v1]=true;
		}//input
		
		visited = new boolean[N+1];
		dfs(from, 0);
		
		System.out.println(result);
	}//end of main

	private static void dfs(int p, int d) {
		
		//방문처리
		visited[p] = true;
		
		//목표
		if(p==to) {
			result=d;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(map[p][i] && !visited[i]){
				dfs(i, d+1); // 관계가 있다면 d+1!
			}
		}
	}//end of dfs
	
}//end of class
