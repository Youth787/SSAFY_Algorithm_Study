package _20250210;

import java.util.*;
import java.io.*;

public class _31714_지정좌석배치하기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] seats = new int[N][M];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				pq.add(Integer.parseInt(st.nextToken())+i*D);
			}
			int tmp=0;
			while(!pq.isEmpty()) {
				seats[i][tmp]=pq.poll();
				tmp++;
			}
		}
		for(int j=0;j<M;j++) {
			for(int i=0;i<N-1;i++) {
				if(seats[i][j]>=seats[i+1][j]) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		
	}

}
