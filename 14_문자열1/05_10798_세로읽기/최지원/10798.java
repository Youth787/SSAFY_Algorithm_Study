//package p10798_세로읽기;

import java.util.Scanner;

//[문제] 다섯 개의 단어를 세로로 읽으려 한다 
//한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [] tmp1 = sc.nextLine().toCharArray();
		char [] tmp2 = sc.nextLine().toCharArray();
		char [] tmp3 = sc.nextLine().toCharArray();
		char [] tmp4 = sc.nextLine().toCharArray();
		char [] tmp5 = sc.nextLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			if (i<=tmp1.length-1) sb.append(tmp1[i]);
			if (i<=tmp2.length-1) sb.append(tmp2[i]);
			if (i<=tmp3.length-1) sb.append(tmp3[i]);
			if (i<=tmp4.length-1) sb.append(tmp4[i]);
			if (i<=tmp5.length-1) sb.append(tmp5[i]);
		}
		
		System.out.println(sb);
	}//main
}//class
