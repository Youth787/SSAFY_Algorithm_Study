package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?

public class _1789_수들의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long sum =0;
		long i =0;
		while (!(sum>N)) {
			i ++ ;
			sum += i;
		}
		
		System.out.println(i-1);
	}// main end 
}
// 수의 범위 때문에 자료형을 long으로 설정해야한다. 
// long type의 변수를 입력받을 때는 
// Long.parseLong을 사용한다. 