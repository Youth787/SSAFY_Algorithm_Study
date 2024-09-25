import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 호석이 두마리 치킨 문제와 동일 
	// 경출도 - 플로이드 워샬 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N+1][N+1];
		int[][] dist = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = adj[b][a] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(adj[i][j]==1) dist[i][j] =adj[i][j];
				else dist[i][j] = 100000;
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		int person =0;
		
		for(int i=1; i<=N; i++) {
			int sum =0;
			for(int j=1; j<=N; j++) {
				sum += dist[i][j];
			}
			if(result>sum) {
				result = sum;
				person = i;
			}
		}
		
		System.out.println(person);
	}
}
