import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dp 문제는 어렵다. 
// 30분동안 고민해도 답이 안나온다면 
// 여러가지 풀이를 보고 많은 문제를 풀어보며 dp를 푸는 법에 익숙해지는것이 좋다.

public class 동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] money = new int[n];
		int[] dp = new int[k+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		
		for(int i =0; i<n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		} // 입력받기 완료 
		
		for(int i=0; i<n; i++) {
			for(int j=money[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-money[i]]+1); 
			}
		}
		System.out.println(dp[k]==Integer.MAX_VALUE-1? -1:dp[k]);
	}// main end 
}

// 100001을 integer.max_value로 설정하면 틀렸습니다가 뜬다.
// integer.max_value-1은 괜찮음 
