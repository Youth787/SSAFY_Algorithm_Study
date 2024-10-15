package _20241016;

import java.util.*;
import java.io.*;

public class _1655_가운데를말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 중간값 이하 저장
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		// 중간값 초과 저장
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			maxHeap.add(tmp);
			
			if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}
			
			if(maxHeap.size()>minHeap.size()+1) {
				minHeap.add(maxHeap.poll());
			}
			
			// 중간값은 항상 maxHeap에 있음.
			bw.write(maxHeap.peek() + "\n");
		}
		// 버퍼 출력
        bw.flush();
        bw.close();
        br.close();
	}

}
