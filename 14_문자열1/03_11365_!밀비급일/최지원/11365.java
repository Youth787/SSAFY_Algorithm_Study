//package p11365_일급비밀;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.nextLine();
		while (!str.equals("END")) {
			StringBuilder sb = new StringBuilder();
			char [] tmp = str.toCharArray();
			for (int i = tmp.length-1; i>=0; i--) {
				sb.append(tmp[i]);
			}
			System.out.println(sb);
			str = sc.nextLine();
		}
				
	}//main
}//class
