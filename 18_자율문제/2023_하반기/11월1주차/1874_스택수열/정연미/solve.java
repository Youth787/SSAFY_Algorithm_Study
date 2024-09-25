package _11월1주차문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int cnt = 0;

		while (N-- > 0) {
			int a = Integer.parseInt(br.readLine());
			if (a > cnt) {
				for (int i = cnt + 1; i <= a; i++) {
					stack.add(i);
					sb.append("+").append("\n");
				}
				cnt = a;
			}
			else if(stack.peek() != a) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}// main end 
}

// 참고 : https://st-lab.tistory.com/182