package p11286_절댓값힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] (연산1)배열에 0이 아닌 정수를 넣고/ (연산2)절댓값이 가장 작은 값을 출력하고 제거하는 자료구조.
//절댓값이 가장 작은 값이 여러개라면 가장 작은 수를 선택
//일반 최소 힙과 비슷하지만 그 비교 기준을 Math.abs로 해야 할 듯.
//처음 시작은 비어있는 배열에서 시작
public class Main {
	
	public static int [] heap = new int [100001]; //최대 연산 수만큼 사이즈 만듦
	public static int idx = 0; //값이 들어가기 시작하는 위치는 1번부터.
	
	public static void main(String[] args) throws IOException {
		
		//이번에는 br, sb 사용해보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //연산 개수
		
		for (int i = 0; i < n ; i++) {
			int x = Integer.parseInt(br.readLine()); //연산 정보
			if (x != 0) push(x);
			else sb.append(pop()).append("\n");
		}//연산 수행 for문
		
		br.close();
		
		System.out.println(sb);//연산 끝난 후 출력
	}//main



	//연산 1: 힙 삽입 ([입력] 0이 아닌 수) ([출력] 없음)
	public static void push(int x) {
		//제일 마지막 노드(idx+1위치)에 값을 먼저 넣는다
		heap[++idx] = x;
		
		//부모와 자식 노드 값 비교(절댓값으로)
		//인덱스
		int child = idx;
		int parent = child/2;
		
		//반복문에서 heap 값의 절대값이 자식이 더 작은 경우에 swap하는 과정
		while(parent > 0 && Math.abs(heap[child]) <= Math.abs(heap[parent])) {
			//부모값이 둘중에 더 작은 수면서, 절대값은 또 같다? 
			if (heap[child] == Math.min(heap[child],heap[parent]) && Math.abs(heap[child]) == Math.abs(heap[parent])) {
				int tmp = heap[child];
				heap[child] = heap[parent];
				heap[parent] =tmp;
				
				//parent, chlid 인덱스 다시
				child = parent; //이제 부모였던 애가 다시 자식으로
				parent = child/2; //그 친구의 부모
			}
			else if (Math.abs(heap[child]) < Math.abs(heap[parent])) {

				int tmp = heap[child];
				heap[child] = heap[parent];
				heap[parent] =tmp;

				//parent, chlid 인덱스 다시
				child = parent; //이제 부모였던 애가 다시 자식으로
				parent = child/2; //그 친구의 부모

			}
		}
		
	}//힙 삽입 (push)

	
	//연산 2: 힙 삭제 ([입력] 0) ([출력] 삭제 전 루트 노드)
	private static int pop() {
		//힙이 비어있다면 0 출력
		if ( idx == 0 ) return 0;
				
		int root = heap[1]; //루트 노드의 값
		
		//마지막 노드의 값을 루트로
		heap[1] = heap[idx--];
		
		//부모와 자식 노드 값 비교(절댓값으로)
		//인덱스
		int parent = 1; //제자리 찾아야 하는얘
		int child = parent*2;//왼자
		
		if (child+1 <=idx && Math.abs(heap[child]) > Math.abs(heap[child+1])) child += 1; //오자
		
		//반복문에서 heap 값의 절대값이 자식이 더 작은 경우에 swap하는 과정
		while( child <=idx  && Math.abs(heap[child]) <= Math.abs(heap[parent])) {
			//부모값이 둘중에 더 작은 수면서, 절대값은 또 같다? 
			if (heap[parent] == Math.min(heap[child],heap[parent]) && Math.abs(heap[child]) == Math.abs(heap[parent])) {
				continue; //이 경우는 멀쩡한 경우라 아무짓도 안하고 넘어가도 됨
			}
			//위에 경우가 아니라면
			int tmp = heap[child];
			heap[child] = heap[parent];
			heap[parent] =tmp;
			
			//parent, chlid 인덱스 다시
			parent = child; //이제 자식였던 애가 다시 부모로
			child = parent*2;//왼자
			
			if (child+1 <=idx && Math.abs(heap[child]) > Math.abs(heap[child+1])) child += 1; //오자

		}
		
		return root;
	}
	
}//class
