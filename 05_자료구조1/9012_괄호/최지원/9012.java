package p9012_괄호;

import java.util.Scanner;
import java.util.Stack;

//[문제] 올바른 괄호문자열인지 아닌지 판단하여 YES, NO로
//[입력] T, 괄호문자열 길이 2이상~50이하
//[출력] YES NO
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc =0; tc<t; tc++) {
			
			Stack<Character> stack = new Stack<>(); //stack으로 구현
			
			char [] inp = sc.next().toCharArray(); //괄호문자열 입력
			for (int i = 0; i<inp.length; i++) {//한문자씩 넣겠다
				//stack이 비어있지 않고, 지금 들어온 값이 닫힌 괄호이며, 현재 stack의 값이 열린 괄호일 때는 이거 삭제 
				if(!(stack.isEmpty()) && inp[i]==')' && stack.peek()=='(') {
					stack.pop();
					continue;
				}
				//위의 if문에 안 걸린다면 그냥 다 넣고, 나중에 stack이 비어있지 않다면 NO
				stack.push(inp[i]); 
			}//판단
			if (stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}//tc
	}//main
}//class
