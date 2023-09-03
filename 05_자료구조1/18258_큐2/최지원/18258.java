package p18258_큐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 정수를 저장하는 큐를 구현한 다음 입력으로 주어지는 명령을 처리하는 프로그램 작성
//push X, pop, size, empty, front, back
//queue는 First In First Out
//[입력] 명령 수 n, 명령어
public class Main {
	
	public static int [] queue = new int[2000000]; //int 자료형 배열 이용하여 stack. 최대 명령 수만큼 사이즈 생성
	public static int front = -1, rear = -1; //현재 아무것도 안들어 있어서 -1로 하나 지워지면 0, 1 : +1해야 지금 제일 앞에 있는 친구의 인덱스 표현
	//front : 마지막으로 삭제된 원소의 위치(앞). 얘도 값이 삭제되면 뒤로 하나씩 움직임
	//rear : 마지막 원소의 위치
	
	public static void main(String[] args) throws IOException {
		
		//전 문제랑 다른 점은 Scanner쓰면 시간초과 쓴다는 점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //명령 수
		
		for (int nn = 0; nn < n; nn++) {
			//명령어 입력 받기(next하고 push면 nextInt까지)
			String cmd = br.readLine();
			if (cmd.equals("pop")) sb.append(pop()).append('\n');
			else if (cmd.equals("size")) sb.append(size()).append('\n');
			else if (cmd.equals("empty")) sb.append(isEmpty()).append('\n');
			else if (cmd.equals("front")) sb.append(front()).append('\n');
			else if (cmd.equals("back")) sb.append(back()).append('\n');	
			else { //push가 젤 받기 까다로우니까 뒤로 뺌
				String [] cmd2 = cmd.split(" "); 
				int value = Integer.parseInt(cmd2[1]);
				push(value);
			}
		}//명령어 처리
		
		//sb 출력
		System.out.println(sb);
	}//main
	
	//push
	public static void push(int value) {
		//가득찰 일은 없는것 같아서 isFull은 따로 신경 안썼음
		queue[++rear] = value; //뒤에 추가하니까 먼저 rear+1
		
	}//push
	
	//pop(가장 앞의 정수를 빼고 출력.isEmpty가 true면 -1출력)
	public static int pop() {
		if (isEmpty()==1) {
			return -1;
		}
		//front이 가지는 값을 출력한 후 front++
		return queue[++front];//지금 front를 출력한 다음 front값 +1
	}//pop
	
	//size(인덱스에서 +1 해야 개수 출력 가능)
	public static int size() {
		return rear-front; //맨 뒤-맨 앞+1
	}//size
	
	
	//empty(비어있으면 1, 아니면 0)
	public static int isEmpty() {
		if (front == rear) { //둘이 같다면 아무것도 없는 상태
			return 1;
		}
		//위의 if문에 걸리지 않았다는 것은 stack에 뭔가 들어있는 상태
		return 0;
	}//isEmpty
	
	//front(isEmpty면 -1)가장 앞 출력
	public static int front() {
		if (isEmpty()==1) return -1;
		return queue[front+1];
	}//front
	
	//back(isEmpty면 -1)가장 뒤 출력
	public static int back() {
		if (isEmpty()==1) return -1;
		return queue[rear];
	}//back
	
}//class
