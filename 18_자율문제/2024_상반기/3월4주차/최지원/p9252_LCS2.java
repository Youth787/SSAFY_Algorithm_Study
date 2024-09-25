//package p9252_LCS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * LCS 최장 공통 부분 수열: 두 수열에서 모두의 부분 수열이 되는 수열 중 가장 긴 것 찾기
 * [입력] 두 문자열(대문자)
 * [출력] LCS 길이, LCS 출력
 * */

/*
 * 접근 방식. 문자열을 저장, 문자열 길이 고려하여 
 * 각 문자열 별로 포인터(?)를 이동하면서 같으면 좌상[r-1][c-1]값에서 +1
 * 다르면 상[r-1][c]값과 좌[r][c-1]값을 비교하여 더 큰 경우의 값을 가져오기
 * */
public class Main {
	static String str1;
	static String str2;
	static int len1;
	static int len2;
	static int[][] strings; //dp용 2차원 배열(해당 위치까지의 가능한 lcs 문자 개수 저장)
	static Stack<Character> stack; //char가 아니었구나
	static String ans=""; //최종 문자열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		len1 = str1.length();
		len2 = str2.length();	
		strings = new int[len1+1][len2+1];
		stack = new Stack<>();
		
		dp(); //dp 메서드를 사용해서 strings을 채운다
		System.out.println(strings[len1][len2]); //strings[len1][len2]에 들어있는 수는 lcs 길이
		
		if (strings[len1][len2] > 0) { 
			//"LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다"
			makeLCS(); //lcs 문자열 쌓기
			System.out.println(ans);			
		}	
	} //main
	
	static void dp() {
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				//두 문자가 같으면 lcs 길이 1이 늘어남, r&c포인터 둘 다 다음으로 이동
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					strings[i][j] = strings[i-1][j-1] + 1;
				} else {
					//두 문자가 다르다면 lcs 길이는 그대로, r 또는 c 포인터를 이동시키기 위해 최대값 비교
					strings[i][j] = Math.max(strings[i-1][j], strings[i][j-1]);
				}
			}
		}
	} //dp
	
	static void makeLCS() {
		int i = len1; 
		int j = len2;
		//거꾸로 탐색하기(문자가 같을 때와, 좌 vs 상 값 비교하며 stack에 역순으로 문자열 push
		while (i > 0 && j > 0) {
			if (str1.charAt(i-1) == str2.charAt(j-1)){
				stack.push(str1.charAt(i-1));
				i--; 
				j--;
			} else if (strings[i-1][j] > strings[i][j-1]) {
				i--;
			} else {
				j--;
			}
		}
		
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
	} //makeLCS
	
} //class
