//package p2675_문자열반복;

import java.util.Scanner;

/*
 * 문자열 s에서 각 문자를 r번 반복해서 새 문자열 만들고 출력
 * 
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int cnt = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < cnt; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	} //main
} //class
