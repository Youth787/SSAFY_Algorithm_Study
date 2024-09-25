package p2562_최댓값;

import java.util.*;

/*
 * 9개 서로 다른 자연수 중 최대값, 그 값이 몇번째로 나온 수인지 출력
 * 
 * */

public class Main {
	public static void main(String[] args) {
		int no = 0;
		int max = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			int tmp = sc.nextInt();
			if (max < tmp) {
				no = i+1;
				max = tmp;
			}
		}
		System.out.println(max);
		System.out.println(no);
	} //main
} //class
