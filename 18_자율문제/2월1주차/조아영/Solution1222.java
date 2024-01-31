import java.util.*;
import java.io.*;

//1222. [S/W 문제해결 기본] 6일차 - 계산기1
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14mbSaAEwCFAYD
public class Solution1222 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for (int t=1; t<=tc; t++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringBuilder sb = new StringBuilder(); //후위연산식 
			Stack<Character> tmp = new Stack<>(); //연산자 보관용 임시 스택 
			for (int i=0; i<length; i++) {
				char c = str.charAt(i);
				if (c!='+') sb.append(c); //숫자면 식에 바로 씀 
				else {
					if (tmp.isEmpty()) tmp.push(c); //연산자면 스택 비었으면 스택에 넣음
					else sb.append(tmp.pop()); //스택에 뭐 있으면 걔를 꺼내서 식에 써
					tmp.push(c); //그리고 방금 받은 새 연산자를 스택에 넣어 
				}
			}
			if (!tmp.isEmpty()) sb.append(tmp.pop());//반복문 끝났는데 스택에 연산자 남아있으면 꺼내서 식에 써줘
			String newStr = sb.toString();
//			System.out.println(newStr);
			Stack<Integer> stack = new Stack<>(); 
			for (int i=0; i<length; i++) {
				char c = newStr.charAt(i);
				if (c!='+') stack.push(c-'0');
				else {
					int a = stack.pop();
					int b = stack.pop();
					stack.push(b+a);
				}
			}
			int ans = stack.pop();
			System.out.printf("#%d %d\n",t,ans);
		}//tc
	}//main
}//class
