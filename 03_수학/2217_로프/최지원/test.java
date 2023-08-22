
//[문제] 로프들을 사용하여 들어올릴 수 있는 최대 중량
//병렬 연결 시 각 로프에는 w(물체 중량)/k(사용 로프 개수)
//[입력] 첫 줄 = 로프 개수 N, 다음줄들에는 최대 중량

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt(); //사용 가능한 로프 수
		int [] rope = new int [N];//최대 중량 저장
		for (int i = 0 ; i <N ;i++) {
			rope[i] = sc.nextInt();
		}
		
		Arrays.sort(rope);
		int ans = 0;
		
		//모든 N개의 로프를 다 쓸 때부터, 제일 무게를 잘 버티는 로프 하나만 쓸 때까지
		for (int i = N; i >=1 ; i--) { 
			int k = i; //(사용로프k=i)
			int w = 0; //중량
			for (int j = N-i; j < N ; j++) {
				w+=rope[j];
			} //로프 당 최대 중량 합
			int per = w/k; //한개당 버텨야 하는 중량
			if (per>rope[N-i]) {
				continue; //제일 작은애가 중량 못 버티면 넘겨
			} else if (per <= rope[N-i]) {
				ans = w;
				break;
			}
		}
		
		System.out.println(ans);

	} //main

} //class
