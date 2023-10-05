import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n]; //각 물건의 무게 weights
		int[] v = new int[n]; //물건의 가치 value
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[k+1];
//		Arrays.fill(dp, 0); //이미 되어있으므로 생략 
//		dp[0]=0; 
		
		//왜 이건 맞고 밑에는 틀리지 
		for (int i=0; i<n; i++) { //i번째 물건까지 고려 
			for (int j=k; w[i]<=j; j--) {
				dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
			}
		}
		
		//이것도 틀림 
//		for (int i=0; i<n; i++) { //i번째 물건까지 고려 
//			for (int j=1; j<=k; j++) { 
//				if (w[i]<=j) dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
//			}			
//		}
		
		//이거 틀림 
//		for (int i=1; i<=k; i++) { //준서의 최대무게 k 만큼까지 dp를 채워야함 
//			dp[i] = dp[i-1];	
//			for (int j=0; j<n; j++) { //물건 n개를 한개씩 고려해볼거야 
//				if (w[j]<=i ) dp[i] = Math.max(dp[i], dp[i-w[j]]+v[j]);
//			}
//		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[k]);
		
	}
	
}

