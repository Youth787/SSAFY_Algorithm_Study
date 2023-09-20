import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//[문제] 정수를 저장하는 덱을 구현한 다음 입력으로 주어지는 명령을 처리하는 프로그램 작성
//push_front X, push_back X, pop_front, pop_back, size, empty, front, back
//덱은 in-out 양쪽에서 가능
//[입력] 명령 수 n, 명령어

//Deque : Double-Ended Queue의 줄임말(하나의 자료구조에 큐+스택)
//Deque의 앞에서 데이터를 넣고 뒤에서 빼면 Queue처럼 사용
//Deque의 앞에서 데이터를 넣고 앞에서 빼면 Stack처럼 사용

//ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 등으로 구현된 클래스 존재

//밑에 덱 메서드 정리


public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//LinkedList로 deque 구현
		Deque<Integer> deque = new LinkedList<>();
		
		int n = sc.nextInt();
		for (int nn = 0; nn<n; nn++) {			
			String cmd = sc.next();
			
			if (cmd.equals("push_front")) deque.offerFirst(sc.nextInt());
			else if (cmd.equals("push_back")) deque.offer(sc.nextInt());
			else if (cmd.equals("pop_front")) {
				if (deque.size()==0) sb.append(-1).append('\n');
				else sb.append(deque.pop()).append('\n');
			}
			else if (cmd.equals("pop_back")) {
				if (deque.size()==0) sb.append(-1).append('\n');
				else {
					sb.append(deque.peekLast()).append('\n');
					deque.pollLast();
				}
			}
			else if (cmd.equals("size")) sb.append(deque.size()).append('\n');
			else if (cmd.equals("empty")) {
				if (deque.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}
			else if (cmd.equals("front")) {
				if (deque.size()==0) sb.append(-1).append('\n');
				else sb.append(deque.getFirst()).append('\n');
			}
			else if (cmd.equals("back")) {
				if (deque.size()==0) sb.append(-1).append('\n');
				else sb.append(deque.getLast()).append('\n');
			}
		}//n개의 명령문
		System.out.println(sb);
	}//main

} //class

//Deque의 앞쪽에 데이터를 삽입 : addFirst(), offerFirst()
//Deque의 뒤쪽에 데이터를 삽입 : addLast() = add(), offerLast() = offer()
//(add-offer의 차이는 add는 용량 초과시 Exception/ offer는  용량 초과시 false 리턴(삽입 후 true))

//덱을 스택으로 사용할때 쓰임 : push(), pop()
//push() = addFirst()와 동일 / pop() = removeFirst()와 동일

//Deque의 앞에서 제거 : removeFirst() = remove() /pollFirst() = poll()
//Deque의 뒤에서 제거 : removeLast(), pollLast()
//(remove-poll 차이는 remove는 덱이 비어있을 때 예외 발생/ poll은 덱이 비어있을 때 null 리턴)

//Deque의 앞쪽에서 찾아서 첫 번째 데이터를 삭제 : removeFirstOccurrence(Object o) = remove(Object o)
//Deque의 뒤쪽에서 찾아서 첫 번째 데이터를 삭제 : removeLastOccurrence(Object o)

//첫 번째 엘리먼트를 확인 : getFirst(), peekFirst() = peek()
//마지막 엘리먼트를 확인 : getLast(), peekLast()
//(get-peek 차이는 get는 덱이 비어있을 때 예외 발생/ peek은 덱이 비어있을 때 null 리턴)

//Object 인자와 동일한 엘리먼트가 포함되어 있는지 확인 : contain(Object o) 
//Deque에 들어있는 엘리먼트의 개수 : size()
