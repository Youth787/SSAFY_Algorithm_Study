//,,오답
//ArrayList로 풀이

import java.util.ArrayList;
import java.util.Scanner;

/*
[문제] 길이가 n인 수열 a에서 소수를 골라 최소공배수를 구한다
[입력] n, a의 원소들
[출력] 소수들의 최소공배수, 소수 없으면 -1 출력
 * */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수열 길이
		ArrayList<Integer> nums = new ArrayList<>();
		
		int ans = 1; //곱 해야 하니까 1로 초기화
		
		for (int i = 1; i <=n; i++) {
			//입력 안하고 바로 확인 n번
			int num = sc.nextInt(); //수열 첫 번째
			int cnt = 0; //2이상의 숫자에서 약수 있나 카운트
			for (int j=2; j<=num;j++) { //j =2~자기자신까지중에
				if (num%j==0) cnt++;//num의 약수가 있다면 cnt++
			}
			if (cnt==1) { //다 확인했는데 자기자신밖에 약수가 없었다면
				if (!nums.contains(num)) { //num을 ArrayList가 안 갖고 있다면
					nums.add(num); //ArrayList에 추가한다
					ans *= num; //그리고 그 숫자를 곱한다
				}
			}
		}//n개의 숫자 반복
		
		//다 돌았는데 ArrayList가 비어있다면 ans를 -1로
		if (nums.isEmpty()) {
			ans = -1;
		}

		System.out.println(ans);

	} //main

} //class
