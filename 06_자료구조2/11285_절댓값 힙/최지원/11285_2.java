import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//[문제] (연산1)배열에 0이 아닌 정수를 넣고/ (연산2)절댓값이 가장 작은 값을 출력하고 제거하는 자료구조.
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//이번에는 br, sb 사용해보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //연산 개수
		
		
		//PriorityQueue : 우선순위큐(들어온 순서대로가 아니라 정해진 우선순위대로 나가는 구조)
		//사용을 위해서는 필수적으로 Comparable Interface를 구현해야 함 : compareTo @override 해줘야 함
		
		//Priority Queue Using Custom Class 참고 (https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90 )
 		
		//ex. 큰 값 우선이라면: PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
		
   
		//람다식 표현 (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
    		// o1,o2라는 값이 들어왔을 때, 둘의 절댓값이 같다면 둘 자체를 비교할 것이고, 절댓값이 다르다면 둘의 절대값끼리 비교를 하여서 우선순위를 정하겠다
	
		//삽입은 add(없으면 예외)나 offer(없으면 null 반환), 루트 반환 및 삭제는 poll이나 remove
		
		//기본적으로 Priority Queue 는 오름차순 정렬. 추가해야 할 것은 절대값끼리 비교하는 부분.
        	PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) ->
        	//o1의 절대값이 o2의 절대값과 같다? (true면) o1과 o2를 비교하여 오름차순 정렬 : (false면) o1와 o2의 절대값끼리 비교하여 오름차순 정렬
            	Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );
		
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());//연산 정보
            
            
            if (x == 0) {
                //연산 2: 힙 삭제 ([입력] 0) ([출력] 삭제 전 루트 노드)
                if (!heap.isEmpty()) {
                    sb.append(heap.poll()).append("\n");
                } else {
                	//힙이 비어있다면 0 출력
                	sb.append(0).append("\n");
                }
            } else {
            	//연산 1: 힙 삽입 ([입력] 0이 아닌 수) ([출력] 없음)
                heap.offer(x);
            }
        }//연산
        
        System.out.println(sb);
        
	}//main

}//class
