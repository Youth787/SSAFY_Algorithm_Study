package _20250203;

import java.util.*;
import java.io.*;

public class _3079_입국심사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] times = new int[N];
		long maxTime =0;
		for(int i=0;i<N;i++) {
			times[i] = Integer.parseInt(br.readLine());
			maxTime = Math.max(times[i],maxTime);
		}
		
		long left = 1;
		long right = maxTime*M;
		long answer = right;
		
		while(left<=right) {
			long mid = (left+right)/2;
			
			// 현재 mid시간 동안 심사 가능한 최대 인원 계산
			long sum =0;
			for(int time : times) {
				sum += mid/time;
				if(sum>=M) break;
			}
			
			if(sum>=M) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(answer);
	}

}
