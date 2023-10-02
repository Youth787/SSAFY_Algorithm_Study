import java.util.Scanner;

public class DP1_11726_2xn타일링 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001];
		dp[1]=1;
		dp[2]=2;
		for (int i=3; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2]; //그림으로 그려보면 피보나치임 
		}
		
		System.out.println(dp[n]%10007);
		sc.close();
		
	}

}
