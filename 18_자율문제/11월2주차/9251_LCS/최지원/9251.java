import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS(Longest Common Subsequence, 최장 공통 부분 수열)
//두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
//문자열은 알파벳 대문자로만 이루어져 있음
//순서가 지켜져야 한다
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] str1 = br.readLine().toCharArray();//문자열1
		char [] str2 = br.readLine().toCharArray();//문자열2

		int len1 = str1.length;
		int len2 = str2.length;
		
		//dp 2차원배열로, 사이즈 하나씩 키워서 
		int [][] dp = new int [len1+1][len2+1];
		
		//str1과 str2의 비교기준 인덱스를 둘다 옮기거나(일치하는 알파벳 발견 시)
		//글자가 일치하지 않아 다음 비교기준 인덱스로 변경하는 방법은 한쪽만 옮기기 : str1에서 또는 str2에서. 그 중 최대값으로

		for (int i = 1; i<=len1; i++) { 
			for (int j = 1; j<=len2; j++) { 
				if (str1[i-1] == str2[j-1]) dp[i][j]=dp[i-1][j-1]+1;//같은 문자열 발견하면 길이(dp) +1
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//한쪽만 비교 기준을 이동한다고 치고 더 큰 값으로 채움
			}
		}
		
		System.out.println(dp[len1][len2]);
	}//main
}//class
