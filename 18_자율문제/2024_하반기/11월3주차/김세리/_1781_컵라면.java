package _20241119;


import java.util.*;
import java.io.*;

public class _1781_컵라면 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] homeworks = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			homeworks[i][0] = Integer.parseInt(st.nextToken());
			homeworks[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(homeworks,(a,b)->{
			if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
			return Integer.compare(a[0],b[0]);
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int[] homework : homeworks) {
			int size = pq.size();
			if(size==0) {
				pq.add(homework[1]);
			}
			else if(size == homework[0]) {
				if(pq.peek() < homework[1]) {
					pq.poll();
					pq.add(homework[1]);
				}
			}
			else if(size < homework[0]) {
				pq.add(homework[1]);
			}
		}
		int ans=0;
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
		System.out.println(ans);
	}

}
