package _20240602;

import java.util.Scanner;

public class _9046_복호화 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc=1;tc<=T;tc++) {
			String s = sc.nextLine().replaceAll(" ", "");
			int n = s.length();
			int[] abc = new int[26];
			int sum =0;
			char ans = '?';
			for(int i=0;i<n;i++) {
				int temp = s.charAt(i)-'a';
				
				abc[temp]++;
				if(sum<abc[temp]) {
					sum = abc[temp];
					ans = s.charAt(i);
				}
				else if(sum==abc[temp]) {
					ans = '?';
				}
			}
			System.out.println(ans);
		}//T
		
	}//main

}
