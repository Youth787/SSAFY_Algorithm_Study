
import java.util.Scanner;

//소수
//[문제] 자연수 M과 N이 주어질 때 M이상 N이하의 자연 수 중 소수인 것을 모두 골라 소수의 합, 최소값.
//소수 없을 때 -1출력
//[입력] 첫 줄 M, 다음에 N (M<=N)
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int ans = -1;  //-1나오게 될 경우 쓸꺼임
		int sum = 0; //소수들을 하나씩 합할꺼임
		int min = 0; //소수 중 최소값
		
//		//M부터 N까지
//		for (int i = M ; i<=N; i++) {
//			//소수인지 확인 : 1과 자기자신만 약수인 경우
//			for (int j = 2; j <N; j++) {
//				if (i/j == 0) {
//					sum+=i;
//				}
//			}
//		
//		} 
		int i = M; //하나씩 커질 예정
		int cnt = 0; //약수 카운트
		while (i<=N) {
			for (int j = 1;j<=i;j++) { //1부터 자기자신까지 중
				if (i%j == 0) {
					cnt++; //나누어 떨어지는 수 있으면 cnt
				} 
				if (j == i && cnt ==2) {
					if (sum == 0) {
						min =i;
					}
					sum+=i;
				}
			}
			i++;
			cnt = 0;
		}
		
		//소수 없을 때 -1출력
		if (sum != 0 ) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(ans);
		}
		
		

	}

}
