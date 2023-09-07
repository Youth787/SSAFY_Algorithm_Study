import java.util.Scanner;

//최대힙과 마찬가지로 풀지만, 루트 노드의 값이 최소값 & 부모<자식노드 값 차이 정도 고려
public class Main {
	
	public static int [] heap = new int [100001]; //최대 연산 개수+1만큼
	public static int idx = 0; //힙엡 아무것도 없는 상태(부모,자식 위치 파악 더 쉽게 하기 위해라고 생각)

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //연산의 개수
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if ( x > 0 ) push(x);//x가 자연수라면 push 수행
			else System.out.println(pop()); //x가 0이라면 pop 수행, 리턴되는 root 출력
		}

	}//main

	//최소 힙 삽입(리턴 따로 필요 없음)
	public static void push(int x) {
		
		heap[++idx] = x; //일단 제일 마지막 노드+1 위치에 넣어
		
		//부모&자식 노드 위치 설정
		int child = idx;
		int parent = child/2;
		
		//설정된 부모노드 위치가 유효하고, 부모 노드 값이 더 클 경우 자식과 swap
		while ( parent > 0 && heap[parent] > heap[child]) {
			int tmp = heap[child];
			heap[child] = heap[parent];
			heap[parent] = tmp;
			
			//다음 반복문에서 사용할 부모&자식 노드 위치 설정
			child = parent; //swap 결과
			parent = child/2;
		}//swap
	}//힙 삽입
	
	//최소 힙 삭제(루트 노드 리턴)
	public static int pop() {
		//힙이 비어있다면 0 출력
		if ( idx == 0 ) return 0;
		
		//리턴할 현재 루트노드 값 (삭제 전)저장
		int root = heap[1];
		
		//제일 마지막위치에 있는 노드의 값을 root에 덮어 씌우고, 힙 현재 사이즈 -1
		heap[1] = heap[idx--];
		
		//부모&자식 노드 위치 설정
		int parent = 1;
		int child = parent*2; //지금은 왼쪽 자식노드
		
		//만약 (오른쪽 자식 노드가 존재하고) 왼쪽 자식과 오른쪽 자식의 크기를 비교하여, 
		//더 작은 친구를 기준으로 부모와 비교하겠다
		if (child+1 <= idx && heap[child] > heap[child+1])  child += 1;
		
		//자식 노드가 지금 힙 사이즈 범위 내(유효한 위치)이면서 동시에 자식노드가 더 작은 상황이면 swap하는 반복문
		while (child <= idx && heap[parent] > heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			//다음에 비교해볼 부모&자식노드 위치 설정
			parent = child; //swap
			child = parent*2;//왼쪽 자식 노드
			
			//오른쪽 자식노드가 존재하고 왼쪽 자식보다 값도 작다면, 비교기준은 오른쪽 자식노드
			if (child+1 <= idx && heap[child] > heap[child+1]) child += 1;
			
		}
		
		return root;

	}//힙 삭제
	
}//class
