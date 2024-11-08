import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
	
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(dp[N][0] % 10007); 
	}

}
