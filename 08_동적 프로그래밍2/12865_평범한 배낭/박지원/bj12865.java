import java.io.IOException;
import java.util.Scanner;

public class bj12865 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int[] dp = new int[k + 1];
		// dp인덱스: 무게
		// dp밸류: 인덱스에서 할 수 있는 한 최대 가치 뽑아내서 바꿔주기
		for (int i = 1; i <= n; i++) {
			for (int j = k; j - w[i] >= 0; j--) {
				dp[j] = Math.max(dp[j],dp[j - w[i]] + v[i]);
			}
		}
		
		
		System.out.println(dp[k]);
	}
}
