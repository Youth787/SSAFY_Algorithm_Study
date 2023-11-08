import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9251 {

	static char[] str1;
	static char[] str2;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(LCS(str1.length - 1, str2.length-1));
		
	}
	static int LCS(int x, int y) {
		if (x == -1 || y == -1) {
			return 0;
		}
		
		//탐색하지 않은 인덱스라면
		if (dp[x][y] == null) {
			dp[x][y] = 0;
			
			//str1의 x번째 문자와 y번쨰 문자가 같은지 확인
			if (str1[x] == str2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else { // 다르다면 옆이나 윗값중 큰 값으로 초기화
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		return dp[x][y];
	}
}

//https://st-lab.tistory.com/139
//여기서 표를 확인하자!! 그래프를!!
//x번째 원소와 y번째 원소가 같다면 (x-1, y-1) 의 LCS길이의 +1이 된다.
//LCS(Xi, Yj) : LCS(Xi-1, Yj-1) + 1                           if (Xi == Yj)    
//LCS(Xi, Yj) : max( LCS(Xi-1, Yj), LCS(Xi, Yj-1) )           if (Xi != Yj)    
