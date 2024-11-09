package _20241113;

import java.util.*;
import java.io.*;

public class _1931_회의실배정_dp이분탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(schedule,(a,b) -> {
			if(a[1]==b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		int[] dp = new int[N];
		dp[0]=1;
		for(int i=1;i<N;i++) {
			dp[i] = dp[i-1];
			
			int idx = binarySearch(schedule,i);
			if(idx!=-1) {
				dp[i] = Math.max(dp[i],dp[idx]+1);
			}
		}
		System.out.println(dp[N-1]);
	}//main
	
	static int binarySearch(int[][] schedule, int current) {
		int left=0, right=current-1;
		int targetStart = schedule[current][0];
		int result =-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(schedule[mid][1]<=targetStart) {
				result = mid;
				left= mid+1;
			}
			else right=mid-1;
		}
		return result;
	}
}
