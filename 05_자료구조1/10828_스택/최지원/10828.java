package p10828_스택;

import java.util.Scanner;

//[문제] 정수를 저장하는 스택을 구현한 다음 입력으로 주어지는 명령을 처리하는 프로그램 작성
//push X, pop, size, empty, top
//[입력] 명령 수 n, 명령어
public class Main {
	
	public static int [] stack = new int[10000]; //int 자료형 배열 이용하여 stack. 최대 명령 수만큼 사이즈 생성
	public static int top = -1; //현재 아무것도 안들어 있어서 top을 -1로.자료들어갈때마다 ++
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); //그냥 sysout하니까 시간초과 떠서..
		
		int n = sc.nextInt(); //명령 수
		
		for (int nn = 0; nn < n; nn++) {
			//명령어 입력 받기(next하고, push면 nextInt까지 입력받기)
			String cmd = sc.next();
			if (cmd.equals("push")) {
				int value = sc.nextInt();
				push(value);
			} else if (cmd.equals("pop")) sb.append(pop()).append('\n'); 
			else if (cmd.equals("size")) sb.append(size()).append('\n');
			else if (cmd.equals("empty")) sb.append(isEmpty()).append('\n');
			else if (cmd.equals("top")) sb.append(top()).append('\n');			
		}//명령어 처리
		
		//sb 출력
		System.out.println(sb);
	}//main
	
	//push
	public static void push(int value) {
		//가득찰 일은 없는것 같아서 isFull은 따로 신경 안썼음
		stack[++top] = value; 
		//먼저 가장 위(인덱스)를 나타내는 top을 +1하고 그 자리에 입력된 정수값 추가
	}//push
	
	//pop(가장 위의 정수를 빼고 출력.isEmpty가 true면 -1출력)
	public static int pop() {
		if (isEmpty()==1) {
			return -1;
		}
		//top이 가지는 값을 출력한 후 top--
		return stack[top--];
	}//pop
	
	//size(인덱스에서 +1 해야 개수 출력 가능)
	public static int size() {
		return top+1;
	}//size
	
	
	//empty(비어있으면 1, 아니면 0)
	public static int isEmpty() {
		if (top == -1) { //top이 -1이라는 것은 stack에 아무것도 없는 상태
			return 1;
		}
		//위의 if문에 걸리지 않았다는 것은 stack에 뭔가 들어있는 상태
		return 0;
	}//isEmpty
	
	//top(isEmpty가 true면 -1 출력)
	public static int top() {
		if (isEmpty()==1) {
			return -1;
		}
		//위의 if에 걸리지 않았다면
		return stack[top]; 
	}//top
	
}//class
