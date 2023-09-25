package p20154_이구역의승자는누구야;

import java.util.Scanner;

//
public class Main {
	static int [] write = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		//알파벳 대문자로만 이루어진 길이 k인 문자열 s
		String str = sc.nextLine();
		int k = str.length();
		int [] kk = new int[k];
		for (int i = 0; i < k; i++) {
			kk[i] = str.charAt(i) - 'A';
		}
		
		System.out.println("I'm a winner!");
		System.out.println("You're the winner?");
	}//main
}//class
