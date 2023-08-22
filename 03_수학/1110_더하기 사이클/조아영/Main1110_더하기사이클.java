package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1110_더하기사이클 {
	
	public static int cnt = 0; //사이클 수 
	public static int origin; //원래 수 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine()); //숫자로 변환 
		origin = n; //입력받은 수를 원래 수로 설정함 
		
		cycle(n); //재귀함수 실행 
		
		System.out.println(cnt); //사이클 끝나면 횟수 출력
	
	}
	
	public static int cycle(int n) {
	
		if (n==origin && cnt>0) { //n이 사이클 1회 이상을 거쳐 원래의 수로 돌아올 경우 
			return cnt; //cnt 값을 반환함 
		}
		
		//원래의 수로 돌아가지 않았다면 다음의 사이클을 실행함 
		int num1 = n%10; //원래 주어진 수의 가장 오른쪽 자리 수 
		int num2 = ( n/10 + n%10 ) %10; //각 자리 수의 합의 가장 오른쪽 자리 수 
		n = num1*10+num2; //두 숫자를 이어붙임 
		cnt++; //사이클 한번 끝났으니까 cnt+1 

		return cycle(n); //재귀함수 형식
	
	}
	

}
