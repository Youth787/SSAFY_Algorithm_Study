import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//요세푸스 문제랑도 비슷해보이지만 풍선 안 숫자에 따라 왼쪽(-), 오른쪽(+)에서 숫자를 양방향으로 처리해야 할듯

//Deque : Double-Ended Queue의 줄임말(하나의 자료구조에 큐+스택)
//Deque의 앞에서 데이터를 넣고 뒤에서 빼면 Queue처럼 사용
//Deque의 앞에서 데이터를 넣고 앞에서 빼면 Stack처럼 사용

//ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 등으로 구현된 클래스 존재

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); //처음 풍선 idx 저장한 deque에서 하나씩 뺄때 여기에 저장 
		int n = sc.nextInt(); //풍선 수
		
		//ArrayDeque로 각각 풍선 속 종이에 적힌 번호와, 풍선의 처음 순서 저장하는 deque 만들었음
		Deque <Integer> deque = new ArrayDeque<>();
		Deque <Integer> idx = new ArrayDeque<>();
		
		//입력
		for (int i = 0; i<n;i++) {
			deque.offer(sc.nextInt());//그냥 offer는 뒤에 넣는 메서드
			idx.offer(i+1); //0부터 시작하니까 n번째 풍선 표현하려면 +1 해야함 
		}
		
		
		
		//다 꺼낼때까지 반복문 돌린다
		//반복문 안에서 deque의 맨 앞에 터트릴 풍선이 오도록 조정(빼고 넣고)
		while (!deque.isEmpty()) {		
			//1번 내용 삭제
			sb.append(idx.poll()+" ");
			int go = deque.poll(); //새로 가야할 방향
			//go가 양수일 떄
			if(!deque.isEmpty() &&go>0) {
				for (int i = 0; i < go - 1; i++) {//n번째 뒤로 이동하려면 go-1 번 이동
					deque.offer(deque.poll());//앞에 있는걸 빼서(poll) 뒤에 넣어(offer)
					idx.offer(idx.poll());//앞에 있는걸 빼서(poll) 뒤에 넣어(offer)
				}
				
			}

			//go가 음수일 때(0은 없음)
			else if(!deque.isEmpty() && go<0) {
				for(int i = 0; i > go; i--) {//n번째 앞으로 이동하려면 go-1번 이동
					//뒤에걸 빼서 앞에 넣어
					deque.offerFirst(deque.pollLast());
					idx.offerFirst(idx.pollLast());
				}
			}
			//다 돌았으면 필요한 수가 맨 앞에
			
		}

		System.out.println(sb);
	}

}
