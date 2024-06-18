package p2577_숫자의개수;

import java.util.Scanner;

/*
 * 3개 자연수 곱한 결과에 0~9가 몇번씩 쓰였는지
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()*sc.nextInt()*sc.nextInt();
		String s = Integer.toString(n);
		int[] cnt = new int[10];		
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - '0']++;
		}
        for (int i = 0; i <= 9; i++) {
            System.out.println(cnt[i]);
        }
	} //main
} //class
