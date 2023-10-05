import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12865_평범한배낭2차원배열 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n+1]; //각 물건의 무게 weights
		int[] v = new int[n+1]; //물건의 가치 value
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][k+1]; //무게 k까지 볼거야 
		
		for (int i=1; i<=n; i++) {//물건 n개 고려 
			for (int j=1; j<=k; j++) {//무게 k까지 고려 
				dp[i][j] = dp[i-1][j]; //기본적으로 이전 아이템의 가치를 저장 
				if (w[i]<=j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
			}
			//System.out.println(Arrays.toString(dp[i]));
		}
		
		System.out.println(dp[n][k]);
		
	}
	
}

