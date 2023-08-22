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
		
		Arrays.sort(rope); //오름차순 정렬
    
		int max = 0;
		int sum = 0;
    
		//1번째 로프부터 로프 중량 * 로프 수
		for (int i = 0 ; i < N; i++) {
			sum = rope[i]*(N-i);
      //결국 기준점은 제일 최대중량 작은 로프가 버틸 수 있는가
			//제일 작은 로프가 버틸 수 있을 만큼 * 제일 작은 로프부터 제일 큰 로프까지의 개수
			if (max<sum) {
				max = sum;
			}
		}
		
		System.out.println(max);

	} //main

} //class
