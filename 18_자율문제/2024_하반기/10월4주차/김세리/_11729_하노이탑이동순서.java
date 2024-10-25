package _20241025;

import java.util.*;
import java.io.*;

public class _11729_하노이탑이동순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		// 이동 횟수 계산 : 2^n-1
		// K-1개 옮기고+ 큰거 하나 옮기고(1회)+K-1개 옮기기
		// K-1개 옮기는 횟수 *2 + 1
		// 이 식대로 구해보면
		// 1개: T(1)=1
		// 2개: T(2)=T(1)*2+1 = 3
		// 3개: T(3)=T(2)*2+1 = 5
		// 4개: T(4)=T(3)*2+1 = 7
		System.out.println((int) Math.pow(2, K)-1);
		
		hanoi(K,1,3,2);
	}
	
	private static void hanoi(int n, int from, int to, int aux) {
		// 원판 1 개를 from 에서 to로 이동
		if(n==1) {
			System.out.println(from+ " "+ to);
			return;
		}
		// n-1개의 원판을 from에서 aux로 이동(to를 보조 기둥으로 사용)
		hanoi(n-1,from,aux,to);
		// 가장 큰 원판을 from에서 to로 이동(그 위에껀 aux로 이동하면서 이동 경로가 출력됨)
		System.out.println(from+" "+to);
		// n-1개의 원판을 aux에서 to로 이동(from을 보조 기둥으로 사용)
		hanoi(n-1, aux, to, from);
	}

}
