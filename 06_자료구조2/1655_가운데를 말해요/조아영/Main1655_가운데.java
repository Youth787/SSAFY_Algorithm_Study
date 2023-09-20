import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main1655_가운데 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine());
		
		//시간초과
//		List<Integer> lst = new ArrayList<>();
//		for (int i=0; i<n; i++) {
//			lst.add(Integer.parseInt(br.readLine()));
//			lst.sort(null);
//			System.out.println(lst.get(i/2));
//		}
		
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		//또는 아래처럼도 구현 가능
//		Queue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2-o1); // 내림차순  
//		Queue<Integer> minHeap = new PriorityQueue<>((o1,o2) -> o1-o2); // 오름차순 
		
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (maxHeap.size()==minHeap.size()) maxHeap.add(num);
			else minHeap.add(num);
			
			//maxHeap의 루트로드가 더 크면(=maxHeap의 최댓값이 minHeap의 최솟값보다 크면) 루트노드끼리 스왑 
			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int tmp = maxHeap.poll(); 
					maxHeap.offer(minHeap.poll());
					minHeap.offer(tmp);
				}
			}
			
			//System.out.println(maxHeap.peek()); //시간초과 
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
