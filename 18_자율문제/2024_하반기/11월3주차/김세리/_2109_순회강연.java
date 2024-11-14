package _20241119;

import java.util.*;
import java.io.*;

public class _2109_순회강연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
			// o1[0]: p,o1[1]: d
			// o2[1], 1[1] 중에 큰 값이 먼저 나오도록
			if(o1[0]==o2[0]) {
				return Integer.compare(o2[1],o1[1]);
			}
			// o1[0], o2[0] 중에 큰 값이 먼저 나오도록
			return Integer.compare(o2[0],o1[0]);
		});
		
		StringTokenizer st;
		int size=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			size = Math.max(size,d);
			pq.add(new int[] {p,d});
		}
		boolean[] cal = new boolean[size+1];
		int ans=0;
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
//			System.out.println(Arrays.toString(curr));
			if(!cal[curr[1]]) {
				cal[curr[1]] = true;
				ans += curr[0];
			}
			else {
				int idx=curr[1]-1;
				out: while(idx>0) {
					if(!cal[idx]) {
						cal[idx] = true;
						ans += curr[0];
						break out;
					}
					idx--;
				}
			}
		}
//		System.out.println(Arrays.toString(cal));
		
		System.out.println(ans);
		
	}

}
