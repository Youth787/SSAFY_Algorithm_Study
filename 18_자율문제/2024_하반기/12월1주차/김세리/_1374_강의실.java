package _20241204;

import java.util.*;
import java.io.*;

public class _1374_강의실 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int classNo = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i][0] = classNo;
			time[i][1] = start;
			time[i][2] = end;
		}
		Arrays.sort(time,(a,b)->{
			if(a[2]==b[2]) {
				if(a[1]==b[1]) {
					return Integer.compare(a[0],b[0]);
				}
				return Integer.compare(b[1],a[1]);
			}
			return Integer.compare(b[2],a[2]);
		});
		PriorityQueue<Integer> lastTime = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			int curNo = time[i][0];
			int curSt = time[i][1];
			int curEn = time[i][2];
			if(lastTime.isEmpty()) {
				lastTime.add(curSt);
			} else {
				if(curEn<=lastTime.peek()) {
					lastTime.poll();
					lastTime.add(curSt);
				} else {
					lastTime.add(curSt);
				}
			}
		}
		System.out.println(lastTime.size());
		
	}

}
