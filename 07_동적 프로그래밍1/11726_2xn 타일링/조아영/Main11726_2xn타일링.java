import java.util.Scanner;

public class Main11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];
		dp[1] = 1; 
		dp[2] = 2; 
		for (int i=3; i<=n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007; 
		}
		System.out.println(dp[n]);
	}
}
