package p2448_별찍기11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * n은 항상 3*2의 k승
 * 만약 %3 == 0 이면 ***** 쉬고 ***** 이런 느낌
 * 
[n = 3]
_ _ * _ _ : (0, 2) 에 별
_ * _ * _ : (1, 1), (1, 3) 에 별
* * * * * : (2, 0) (2, 1) (2, 2) (2, 3) (2, 4) 에 별
[n = 24]
- 3 * 작은 삼각형 8 층 짜리
- 제일 마지막 층 = 5* 작은 삼각형 8개 + 사이사이 공백 7개 = 47칸 = 24*2 -1
= 꼭대기 층부터 쌓아간다고 생각하고 옆으로 퍼져야함
 * */
public class Main {
	static int n;
	static StringBuilder sb[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
		sb = new StringBuilder[n]; //n줄 만들자
		for (int i = 0; i < n; i++) {
			sb[i] = new StringBuilder();
			for (int j = 0; j < 2*n -1; j++) {
				sb[i].append(' ');
			}
		}
		
		star(0, n-1, n); //꼭대기 층(0)부터, 정가운데에서( 0~ 2n-2 에서 가운데 = n-1), 층수로 구분하면서 별 찍기(n)
		
		for (StringBuilder sb2 : sb) {
			System.out.println(sb2);
		}
		
	} //main
	private static void star(int r, int c, int nowN) {
		if (nowN == 3) {
			sb[r].setCharAt(c, '*');
			sb[r+1].setCharAt(c-1, '*');
			sb[r+1].setCharAt(c+1, '*');
			sb[r+2].setCharAt(c-2, '*');
			sb[r+2].setCharAt(c-1, '*');
			sb[r+2].setCharAt(c, '*');
			sb[r+2].setCharAt(c+1, '*');
			sb[r+2].setCharAt(c+2, '*');			
		} else {
			int nextN = nowN / 2;
			star(r, c, nextN);
			star(r+nextN, c-nextN, nextN);
			star(r+nextN, c+nextN, nextN);
		}
		
	}
} //class
