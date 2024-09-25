package p1834_나머지와몫이같은수;

import java.util.Scanner;

/*
 * n으로 나누면 나머지=몫인 모든 자연수의 합을 구하기
 * 
 * n=1: 없음 / n=2: 3 / n=3: 4, 8 / n=4: 5, 10, 15 / ...
 * 
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += (n + 1)*i;
		}
		
		System.out.println(ans);

	} //main

} //class
