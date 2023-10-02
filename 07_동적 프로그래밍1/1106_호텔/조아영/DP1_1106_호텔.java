import java.util.Arrays;
import java.util.Scanner;

//참고: https://dingdingmin-back-end-developer.tistory.com/entry/백준-1106-자바-java-호텔
public class DP1_1106_호텔 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt(); //목표 고객 최소치 
		int n = sc.nextInt(); //도시 수 
		
//		int[] cost = new int[n+1];
//		int[] customer = new int[n+1];
		int[] dp = new int[c+101]; //고객이 c+100명 와도 상관없음 
		Arrays.fill(dp, 987654321); 
		dp[0] = 0; 
		
		for (int i=1; i<=n; i++) {
//			cost[i] = sc.nextInt();
//			customer[i] = sc.nextInt();
//			for (int j=customer[i]; j<c+101; j++) {
//				dp[j]=Math.min(dp[j], dp[j-customer[i]]+cost[i]);
//			}
			int cost = sc.nextInt();
			int customer = sc.nextInt();
			for (int j=customer; j<c+101; j++) {
				dp[j] = Math.min(dp[j], dp[j-customer]+cost);
			}
		}
		
		int ans=987654321;
		for (int i=c; i<c+101; i++) {
			ans=Math.min(ans, dp[i]);
		}
		System.out.println(ans);
		sc.close();
		
	}
	
}
