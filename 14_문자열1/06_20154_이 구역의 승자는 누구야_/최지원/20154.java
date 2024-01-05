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
		int [] kk = new int[k];//주어진 문자열의 각 획을 저장하는 배열
		for (int i = 0; i < k; i++) {
			kk[i] = write[str.charAt(i) - 'A']; //문자열의 i번째 글자가 write의 어디에 해당하는지를 찾고, kk에 저장하는 과정
		}

		int sum = 0;
		
		for (int i = 0; i < kk.length; i++){
			sum += kk[i];
			sum %= 10; //10이 넘어가면 10으로 나눈 나머지를 저장
		}

		if (sum % 2 == 0) System.out.println("You're the winner?");
		else  System.out.println("I'm a winner!");
		
	}//main
}//class
