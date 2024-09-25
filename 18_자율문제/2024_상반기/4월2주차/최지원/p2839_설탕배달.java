package p2839_설탕배달;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 3, 5키로 봉지로 목표 무게 달성할 수 있는 최소 봉지 개수
 * 정확히 n키로가 안된다면 -1 출력
 * 3 <= n <= 5000
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
// 5를 기준으로, 나머지가 0이면 n/5
// 나머지가 1일때랑 3일때는 n/5 + 1
// 나머지가 2일때랑 4일때는 n/5 + 2 (단, n = 4와 7은 제외)
		
//무게		3 4 / 5 6 7 8 9 / 10 11 12 13 14 / 15 16 17 18 19 / 20 21 ...
//봉지 수   	1 0 / 1 2 0 2 3 / 2  3  4  3  4  / 3  4  5  4  5  / 4  5
//5로나우면 몫	0   /     1     /        2       /        3       /    4
//나머지		3 4 / 0 1 2 3 4 / 0  1  2  3  4  / 0  1  2  3  4  / 0  1
		int ans = 0;
		if (n == 4 || n ==7) {
			ans = -1;
		} else if (n%5 == 0) {
			ans = n/5;
		} else if (n%5 == 1 || n%5 == 3) {
			ans = n/5 + 1;
		} else {
			ans = n/5 + 2;
		}
		
		System.out.println(ans);
		
	} //main
} //class
