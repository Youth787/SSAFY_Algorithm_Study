import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] visit;
	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		ans = 987654321;
		visit = new boolean[N];
		set(0);
		System.out.println(ans);
	}// main end

	public static void set(int idx) {
		if (idx == N) {
			check();
			return;
		}

		visit[idx] = true;
		set(idx + 1);
		visit[idx] = false;
		set(idx + 1);
	}

	public static void check() {
		int start =0;
		int link =0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
			if(visit[i]!=visit[j]) {
				continue;
			}
			if(visit[i]) 
				start += graph[i][j]+graph[j][i];
			else 
				link += graph[i][j]+graph[j][i];
			}
		}
		
		int temp = Math.abs(start-link);
		ans = Math.min(ans, temp);	
	}
}