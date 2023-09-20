import java.util.Arrays;
import java.util.Scanner;

public class Main2294_동전2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전 종류
		int k = sc.nextInt(); //목표 합 
		int[] arr = new int[n]; //동전들 배열 
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		int[] dp = new int[k+1]; 
		Arrays.fill(dp, 100001); 
		dp[0] = 0; 
		// dp[a] = b 일 경우 a원을 만들기 위한 동전의 최소 개수 = b 
		// dp[a] = min(dp[x-n개의 각 동전의 가치]+1) 
		
		for (int i=0; i<n; i++) {
			for (int j=arr[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		System.out.println(dp[k]==100001 ? -1 : dp[k]);
	}
}
