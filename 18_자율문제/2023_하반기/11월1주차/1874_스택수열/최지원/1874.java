package p1874_스택수열;
//https://www.acmicpc.net/problem/1874
//문제: 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
//이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
//임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

//출력: 한 줄에 한 개씩 출력한다. push 연산 : + / pop 연산 : - / 불가능한 경우 NO
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		
		Stack <Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		int st = 0;//앞의 숫자 저장
		
		//둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진
		while(n > 0) {
			
			int number = Integer.parseInt(br.readLine());//이번 줄에서의 정수
			
			if(number > st) {
				for(int i = st + 1; i <= number; i++) {
					stack.push(i);
					sb.append('+').append('\n');// +
				}
				st = number; //스택에 push하는 순서는 반드시 오름차순
			}
			
			// top 원소가 입력값과 다를때 
			else if(stack.peek() != number) {
				System.out.println("NO");
				return;	
			}
			
			stack.pop();//꺼내
			sb.append('-').append('\n');
			
			n--;
			
		}
		
		System.out.println(sb);
	}//main
}//class
