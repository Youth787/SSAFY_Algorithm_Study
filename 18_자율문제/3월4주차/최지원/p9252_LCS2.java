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
	static int[][] strings;
	static Stack<Character> stack; //char가 아니었구나
	static String ans="";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		len1 = str1.length();
		len2 = str2.length();	
		strings = new int[len1+1][len2+1];
		stack = new Stack<>();
		
		dp();	
		System.out.println(strings[len1][len2]);
		
		if (strings[len1][len2] > 0) {
			makeLCS();
			System.out.println(ans);			
		}	
	} //main
	
	static void dp() {
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					strings[i][j] = strings[i-1][j-1] + 1;
				} else {
					strings[i][j] = Math.max(strings[i-1][j], strings[i][j-1]);
				}
			}
		}
	} //dp
	
	static void makeLCS() {
		int i = len1, j = len2;
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
