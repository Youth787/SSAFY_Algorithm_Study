import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 메모리 초과 발생 
public class queue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Queue<Integer> test = new LinkedList<>();
		
		int t =0;
		for(int i =0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			pq.offer(a);
			
			if(pq.size()==1) 
				sb.append(pq.peek()+"\n");
			else if(pq.size()%2==0) { // 짝수일때
				t = pq.size()/2;
				for(int j =0; j<t-1; j++) 
					test.offer(pq.poll());
				
				int first = pq.poll();
				int second = pq.poll();
				
				if( first>second) sb.append(second+"\n");
				else sb.append(first+"\n");
				
				pq.offer(first);
				pq.offer(second);
				
				for(int j =0; j<t-1; j++) 
					pq.offer(test.poll());
				
			}else { // 홀수 일때 
				t = pq.size()/2;
				for( int j=0; j<t; j++) 
					test.offer(pq.poll());
				
                sb.append(pq.peek()+"\n");
				
				for( int j=0; j<t; j++) 
					pq.offer(test.poll());
			}
		} 
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}// main end 
}
