import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 수열 a에서 가장 긴 감소하는 부분 수열을 구함
 * 
 * */
public class Main {
	static int n;//수열 a의 크기.
	static int ans;
	static int[] num;//수열 a.
	static int[] dp;//각 위치에서 끝나는 가장 긴 감소하는 부분수열의 길이 저장.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		num = new int[n];//num 배열 size 설정
		dp = new int[n];//dp 배열 size 설정
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}//num 원소 입력
	
		Arrays.fill(dp, 1);//자기자신(길이 1개짜리로 초기화)
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (num[j] > num[i] && dp[i] < dp[j]+1) {
					//i보다 앞에 있는 모든 j들을 검토하고 num[i]를 마지막으로 하는 감소 수열 중 가장 긴 길이 저장
					dp[i] = dp[j] + 1;
				}
			}
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}
		
		System.out.println(ans);
	}//main
	
}//class
