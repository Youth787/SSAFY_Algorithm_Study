package _20250113;

import java.util.*;
import java.io.*;

public class _3078_좋은친구 {
	static int N, K;
	static int[] lengthCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lengthCount = new int[21];
		Queue<Integer> q = new LinkedList<>();
		
		long cnt=0;
		
		for(int i=0;i<N;i++) {
			int len = br.readLine().length();
			cnt += lengthCount[len];
			
			q.add(len);
			lengthCount[len]++;
			
			if(q.size()>K) {
				int removedLength = q.poll();
				lengthCount[removedLength]--;
			}

		}
			
		System.out.println(cnt);
	}
	
}
