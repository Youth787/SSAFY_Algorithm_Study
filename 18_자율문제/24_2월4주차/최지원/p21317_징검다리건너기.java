import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[2][Math.max(4,N)];
		for (int i = 1; i <= N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[0][i] = Integer.parseInt(st.nextToken());
			board[1][i] = Integer.parseInt(st.nextToken());		
		}
    
		int K = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[2][Math.max(4, N+1)];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 10000);
		}
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 0;
		dp[0][2] = board[0][1];
		dp[0][3] = Math.min(dp[0][2] + board[0][2], dp[0][0]+board[1][1]);
		for (int i = 4; i <= N; i++) {
			dp[0][i] = Math.min(dp[0][i-1] + board[0][i-1], dp[0][i-2] + board[1][i-2]);
			dp[1][i] = Math.min(Math.min(dp[1][i-1] + board[0][i-1], dp[1][i-2] + board[1][i-2]),dp[0][i-3]+K);
		}
		int answer = Math.min(dp[0][N], dp[1][N]);
		System.out.println(answer);
	}
}
