package p16637_괄호추가하기;
/*
 * 길이 n 수식을 왼쪽부터 순서대로 계싼. 0~9 정수와 우선순위 없는 연산자 + = x
 * 중첩된 괄호는 없다
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N; 
  static int result;
	static char[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new char[N];

		input = br.readLine().toCharArray();

		result = Integer.MIN_VALUE;
		solve(2, input[0] - '0');
		System.out.println(result);
	} //main

  //인자로 현재 숫자의 인덱스값, 현재까지의 (합)결과
	static void solve(int i, int sum) {
		//기저
		if (i >= N) {
			result = Math.max(result, sum);
			return;
		}
		
		// 괄호 안 친 경우의 재귀
		solve(i+2, cal(sum, input[i]-'0', input[i-1]));		
		// 오른쪽에 괄호 친 경우의 재귀
		if (i + 2< N) {
			// 옆 괄호 먼저 계산
			int right = cal(input[i]-'0', input[i+2]-'0' , input[i+1]);
			// 지금까지 결과와 합하기
			int left = cal(sum, right, input[i-1]);
			solve(i+4, left);
		}
	} //solve

  //연산자에 따른 계산
	static int cal(int i, int j, char op) {
		if (op == '+') {
			return i + j;
    } else if (op == '-') {
			return i - j;
    } else {
			return i * j;
    }
  } //cal
} //class
​
