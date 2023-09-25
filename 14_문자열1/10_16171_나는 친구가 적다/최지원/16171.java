//이거 왜 틀려유,...
//package p16171_나는친구가적다;

import java.util.Arrays;
import java.util.Scanner;

//[문제] 알파벳 소문자와 대문자로 이루어져 있는 교과서에서 찾는 키워드의 존재 여부
//[입력] 첫 줄 문자열 s(알파벳 소문자, 대문자, 숫자) >= 키워드 문자열 k(알파벳 소문자, 대문자)
//[출력] 키워드가 존재하면 1, 아니면 0
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//주어진 문자열
		String find = sc.nextLine();//키워드문자열
		String word = "";//새롭게 만들어진 문자열
		int ans = 0;

		//숫자를 뜻하는 아스키 코드 범위 내면 제외(48~57)
		out : for (int i = 0; i< str.length(); i++) { 
			char tmp1 = str.charAt(i);
			if (tmp1 >= 48 && tmp1 <= 57) continue;
			if (tmp1 == find.charAt(0)) { //거기부터 숫자 제외하고 단어만 연결
				for (int j = i+1; j<str.length(); j++) {
					if (str.charAt(j) >= 48 && str.charAt(j) <= 57) continue;
					else word += str.charAt(j);	
					if (word.length()==find.length()) {
						if (word.equals(find)) {
							ans = 1;
							break out;
						}
					}
						
				}
				
			}		
		}
		System.out.println(ans);
		
		
	}//main
}//class
