package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS 로 푸는법 
// DP로는 어떻게 풀지..?

public class 징검다리건너기 {
	static int K, N, min;
	static int[][] energy;
	static int ans = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		energy = new int[N][2];
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			energy[i][0] = Integer.parseInt(st.nextToken());
			energy[i][1] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		
		DFS(0,1,false);
		System.out.println(ans);
	}// main end 

	static void DFS(int sum, int to, boolean check) {
		if(to==N) { // 마지막 돌에 도달하면 에너지 최솟값을 구한다. 
			ans = Math.min(ans, sum);
			return;
		}
		
		if(to>N) return; // 돌개수 넘어서버리면 return;
	
		DFS(sum+energy[to][0],to+1,check); // 작은점프 
		DFS(sum+energy[to][1],to+2,check); // 큰점
		
		// 3단 점프를 사용하지 않았을 경우. 
		if(!check) DFS(sum+K, to+3, true);
	}// method mend
}
