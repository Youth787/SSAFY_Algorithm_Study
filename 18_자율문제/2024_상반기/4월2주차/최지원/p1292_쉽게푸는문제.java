package p1292_쉽게푸는문제;

import java.util.Scanner;

/*
 * a ~ b 구간의 숫자 합 구하기
 * 
 * a가 어디인지 구하고 1 + 2 + 3 + .. 번째
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		// 현재 숫자를 도는 반복문에서 인덱스가 a일때부터 합을 구해서 b까지 합을 구함
		int now = 1;//현재 반복되고 있는 숫자
		int idx = 1;//지금 몇번째 수인지(수열에서의 위치)
		int sum = 0;
		
		while (idx <= b) { //b 이하일때까지 반복
			for (int i = 0; i < now && idx <= b; i++) { 
				//now가 수열에 등장하는 횟수만큼 만복
				if (idx >= a) { //idx가 a 이상일때부터 합을 구하기 시작
					sum += now;
				}
				idx++; //수열 다음 수로 넘어감
			}
			now++; //반복되는 수를 하나 키움
		}

		System.out.println(sum);
	} //main

} //class

//아직 for문 조건식 2개 쓸때가 조금 어색함
//for (int i = 0; i < 10 && 조건식; i++) {
// 반복 실행될 코드
//}
