package _20240602;

import java.util.Scanner;

public class _11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int sum=0;
		for(int i=0;i<n;i++) {
			sum += Integer.parseInt(s.substring(i, i+1));
		}
		System.out.print(sum);
	}

}
