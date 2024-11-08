package _20241113;

import java.util.*;
import java.io.*;

public class _19623_회의실배정4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
			schedule[i][2] = Integer.parseInt(st.nextToken());
		}
		// 종료시간 기준으로 정렬
		Arrays.sort(schedule, Comparator.comparingInt(a -> a[1]));

		int[] dp = new int[N];
		dp[0] = schedule[0][2];
		
		for(int i=1;i<N;i++) {
			
			// 1. 현재 회의를 포함하지 않을 경우(아래 둘 중 큰 것 선택)
			//  -> 이전까지의 최대값을 그대로 가져오거나
			//  -> 이전까지 값을 버리고 현재 값을 추가한다
			dp[i] = Math.max(dp[i-1],schedule[i][2]);
			
			// 2. 현재 회의를 포함하는 경우
			//  -> 현재 회의와 겹치지 않는 마지막 회의를 찾고, 그 dp값을 더한다
			//  -> 1의 경우의 결과값과 비교하여 큰 값을 dp[i]에 저장한다
			int idx = binarySearch(schedule,i);
			// 겹치지 않는 회의가 있다면
			if(idx!=-1) {
				dp[i] = Math.max(dp[i],dp[idx]+schedule[i][2]);
			}
		}

		System.out.println(dp[N-1]);
	}
	
	private static int binarySearch(int[][] schedule, int current) {
		int left=0, right = current-1;
		int targetStart = schedule[current][0];
		int result =-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			// 종료 시간이 현재 회의의 시작 시간 이하인 경우
			if(schedule[mid][1] <= targetStart) {
				// 가능한 회의 저장
				result = mid;
				// 더 늦게 끝나는 회의를 찾는다
				left = mid+1;
			} else {
				// 범위 줄임
				right = mid-1;
			}
		}
		// 현재 회의와 겹치지 않는 마지막 회의의 인덱스
		return result;
	}
}
