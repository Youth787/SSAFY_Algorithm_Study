//문제: 2의N승 * 2의N승 2차원 배열을 4등분하여 (큰&작은)Z모양으로 탐색할 때, n이 주어졌을 때 r행c열을 몇 번째로 방문하는지 출력
//입력: n, r, c - 출력: r행 c열을 몇 번째로 방문했는지 출력
// 1 ≤ N ≤ 15 . 0 ≤ r, c < 2의 n승

import java.util.Scanner;

public class Main {
	static int cnt = 0;

	public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int size = (int) Math.pow(2, n); //처음 입력 받았을 때의 사이즈 (2의N승)
		
		slove(size, r, c);
		System.out.println(cnt);
	}//main

	private static void slove(int size, int r, int c) {
    //기저조건
		if (size == 1)
			return;

    //재귀
		if (r < size/2 && c < size/2) { //왼위
			slove(size/2, r, c);
		}//왼위
		else if (r < size/2 && c >= size/2) { //오위
			cnt += (size * size / 4);
			slove(size/2, r, c - size/2);
		}//오위
		else if (r >= size/2 && c < size/2) { //왼아
			cnt += (size * size / 4) * 2;
			slove(size/2, r - size/2, c);
		}//왼아
		else { //오아
			cnt += (size * size / 4) * 3;
			slove(size/2, r - size/2, c - size/2);
		}//오아
	}//slove
}//class
