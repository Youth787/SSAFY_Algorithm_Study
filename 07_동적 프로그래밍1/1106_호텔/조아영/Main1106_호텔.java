import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1106_호텔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()); //목표 고객 최소치 
		int n = Integer.parseInt(st.nextToken()); //도시 수 
		
		int[] dp = new int[c+101];
		dp[0] = 0; 
		Arrays.fill(dp, 999999);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			for (int j=g; j<c+101; j++) {
				dp[j] = Math.min(dp[j], dp[j-g]+f);
			}
		}
		int ans = 999999;
		for(int j=c; j<c+101; j++){
			ans = Math.min(ans, dp[j]);
		}
		System.out.println(ans);
	}
}
