import java.util.Scanner;

//참고: https://st-lab.tistory.com/194
public class DP1_1010_다리놓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		//nCr 구할 건데 행이 n이고 열이 r임 
		int[][] dp = new int[31][31];
		for (int i=0; i<31; i++) {
			dp[i][i] = 1; 
			dp[i][0] = 1; 
		}
		for (int i=1; i<31; i++) {
			for (int j=1; j<31; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				//(n+1)C(r+1) = (n)C(r)+(n)C(r+1)
			}
			//System.out.println(Arrays.toString(dp[i]));
		}
		
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt(); //서쪽 사이트 개수 
			int m = sc.nextInt(); //동쪽 사이트 개수  //mCn 하면 됨 
//			long[] dp = new long[31];
//			dp[1]=1;
//			for (int i=2; i<=m; i++) {
//				dp[i] = dp[i-1]*i; 
//			}
//			ans = dp[m] / (dp[m-n] * dp[n]);  //숫자 너무 커져서 오류남 
			
			System.out.println(dp[m][n]);		
		}
		sc.close();
	}
	
}
