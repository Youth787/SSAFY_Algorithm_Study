import java.util.Scanner;

//[문제] 최대힙
//완전이진트리. 부모 노드 값이 자식 노드의 값보다 크거나 같음. 루트는 트리 내 최대값
//부모: 자식/2, 왼자:부모*2, 오자:부모*2+1
public class Main {

	public static int [] heap = new int[100001]; //힙을 배열로, 최대연산개수만큼 크기 설정
	public static int idx = 0; //힙 인덱스(빈 상태)
	//부모,자식 위치 판단하려면 루트노드의 우선순위(인덱스)가 0이 아니라 1인것이 낫다
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//연산 개수(n<=100,000)		
		
		for (int i = 0; i<n; i++) {
			int x = sc.nextInt();
			
			//연산1 : [삽입] 배열에 자연수x를 넣는다
			if (x > 0) push(x); //이땐 출력 없이 x를 push	
			//연산2 : [삭제] 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거
			else System.out.println(pop());
		}//연산 수행

	}//main
	
	//힙 삽입
	public static void push(int x) {
		heap[++idx] = x;//x를 지금 가잔 마지막 노드에 넣음
		
		int child = idx;//자식노드 인덱스
		int parent = child/2; //부모노드 인덱스
		
		//부모노드 값이 더 작을 때 swap
		while (parent > 0 && heap[child] > heap[parent]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			//바뀐대로 자식&부모 노드 인덱스 바꾸고 반복문 진행
			child = parent;
			parent = child/2;
			
			//
		}
	}//힙 삽입
	
	//힙 삭제(루트 노드 return하고 삭세)
	public static int pop() {
		//힙이 비어 있다면 할 수 있는 일이 없음. 이때 0을 출력하래
		if (idx == 0) return 0;
		
		//밑부분은 힙이 비어있지 않다면 수행
		int root = heap[1]; //루트 노드 값 저장. 마지막에 리턴
		
		//제일 마지막 노드를 루트로 가져옴으로써 기존 루트 노드 값 삭제
		heap[1] = heap[idx--];//루트가 하나 빠졌으니까 idx(=힙 사이즈)도 이 문장 처리 후 -1
		
		//마지막 노드가 루트가 되었으니 자식들과 값 비교하여 제자리 찾는 과정
		int parent = 1;//루트 노드 위치=부모 위치 시작점
		int child = parent*2; //왼자식 위치
		//좀 더 간단히 하기 위해, 오른쪽 자식노드이 왼쪽 자식노드보다 값이 크다면 그 친구를 기준으로 비교하겠다
		if (child +1 <= idx && heap[child] < heap[child+1]) child +=1;
		
		//자식 노드가 지금 힙 사이즈 내에 있으면서(유효하면서) 자식노드 값이 부모모다 더 클 때 swap
		while(child <= idx && heap[parent]< heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			//바뀐대로 자식&부모 노드 인덱스 바꾸고 반복문 진행
			parent = child;
			child = parent*2;
			
			//오른쪽 자식이 왼쪽 자식 노드 값보다 크다면 child 값 조정
			if (child +1 <= idx && heap[child] < heap[child+1]) child +=1;

		}
		
		return root;
		
	}//힙 삽입

}//class
