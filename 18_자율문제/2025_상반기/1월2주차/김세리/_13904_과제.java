package _20250125;

import java.util.*;
import java.io.*;

public class _13904_과제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] list = new int[N][2];
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(d>cnt) cnt=d;
			list[i][0] = d;
			list[i][1] = w;
		}
		Arrays.sort(list, (o1,o2)->{
			if(o1[0]==o2[0]) {
				return Integer.compare(o2[1],o1[1]);
			}
			return Integer.compare(o2[0],o1[0]);
		});
		int ans=0;
		int idx=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=cnt;i>0;i--) {
			while(idx<N && list[idx][0]>=i) {
				pq.add(list[idx][1]);
				idx++;
			}
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.println(ans);
	}

}
