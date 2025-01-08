package _20250113;

import java.util.*;
import java.io.*;

public class _19598_최소회의실개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(schedule,(a,b)-> Integer.compare(a[0],b[0]));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int[] meeting:schedule) {
			if(!pq.isEmpty() && meeting[0]>=pq.peek()) {
				pq.poll();
			}
			pq.add(meeting[1]);
			
		}
		System.out.println(pq.size());
	}

}
