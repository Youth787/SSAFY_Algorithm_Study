import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다들 dfs로 풀던데 dp로 풀어봄 (인터넷 약간 참고... 자바 dp 풀이글이 전멸해서 c++,파이썬 풀이에서 약간 힌트 얻음)
//우선 작은점프,큰점프만 고려하고 매우큰점프는 나중에 추가해보는 게 핵심 
//특수케이스(여기서는 n<=3) 늘 주의하자 
public class DP1_21317_징검다리건너기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //n개의 돌 
		int[][] jump = new int[n][2];
		
		for (int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			jump[i][0] = Integer.parseInt(st.nextToken()); //작은점프(현재위치+1)
			jump[i][1] = Integer.parseInt(st.nextToken()); //큰점프(현재위치+2)
		}
		int k = Integer.parseInt(br.readLine()); //매우큰점프(딱한번)(현재위치+3) 

		int[] dp = new int[n+1]; //각 돌까지 가는 데 필요한 에너지의 최솟값 
		dp[0] = 0; 
		dp[1] = 0;
		if (n>1) dp[2] = jump[1][0]; //여기 가는 방법은 1에서 작은점프 1번밖에 없음 
		
		for (int i=3; i<=n; i++) { 
			dp[i] = dp[i-1]+jump[i-1][0]; //일단 작은점프 해서 간 값을 넣고 
			dp[i] = Math.min(dp[i], dp[i-2]+jump[i-2][1]); //큰점프 해서 간 값과 비교해 
		}
		//System.out.println(Arrays.toString(dp));
		
		if (n<=3) System.out.println(dp[n]); //n이 3 이하면 매우큰점프 못하니까 밑에 할 필요 없어 
		else { //여기서부터는 매우큰점프 고려해볼 것 
			int[][] dp2 = new int[n+1][n+1]; 
			for (int i=0; i<=n; i++) {
				for (int j=0; j<=n; j++) dp2[i][j]=dp[j]; //일단 dp를 복사해옴  
				if (i<4) continue; //i<4면 매우큰점프 못하니까 continue 
				for (int j=i; j<=n; j++) { //i번째 돌에 매우큰점프로 도착해볼거임 
					if (j==i && dp2[i][j]>dp2[i][j-3]+k) { 
						dp2[i][j] = dp2[i][j-3]+k; //i번째 돌에 매우큰점프 해서 간 값이 더 작으면 매우큰점프 ㄱㄱ 
						if (j+1<=n) dp2[i][j+1] = dp2[i][j]+jump[i][0]; //바로 다음돌에는 작은점프로만 갈수있어 
					}
					if (j>i+1) dp2[i][j] = Math.min(dp2[i][j-1]+jump[j-1][0], dp2[i][j-2]+jump[j-2][1]); //다다음돌부턴 작은점프or큰점프 비교 
				}
			}

//			for (int i=0; i<=n; i++) {
//				System.out.println(Arrays.toString(dp2[i]));
//			}
			
			//여기까지 하면 dp2는 각 돌에 매우큰점프로 도착한 경우의 수를 모두 구한 것  
			//이제 dp2[i][n]중에 최적해를 찾으면 됨 
			int ans = 100001;
			for (int i=2; i<=n; i++) {
				if (ans>dp2[i][n]) ans = dp2[i][n];
			}
			System.out.println(ans);
		}
				
	}
	
}
