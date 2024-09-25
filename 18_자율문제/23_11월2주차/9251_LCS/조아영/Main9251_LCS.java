import java.io.*;

public class Main9251_LCS {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String m = br.readLine();
		
		int ns = n.length();
		int ms = m.length();
		
		int[][] dp = new int[ns+1][ms+1];
		for (int i=1; i<=ns; i++) {
			for (int j=1; j<=ms; j++) {
				if (n.charAt(i-1)==m.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
		}
		System.out.println(dp[ns][ms]);
		
		
	}
	
}
