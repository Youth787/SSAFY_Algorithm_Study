package _20250203;

import java.util.*;
import java.io.*;

public class _1365_꼬인전깃줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]cables = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			// 왼쪽 전깃줄 번호에 맞춰서 오른쪽도 변환해서 저장
			cables[i] = Integer.parseInt(st.nextToken())-1;	
		}
		// 최장 증가 부분 수열(LIS, Longest Increasing Subsequence) 저장
		List<Integer> lis = new ArrayList<>();
		
		for(int num : cables) {
			// 이분탐색을 이용해서 num이 들어갈 위치를 찾는다
			int idx = Collections.binarySearch(lis,num);
			// 음수이면 삽입할 위치를 변환해준다
			if(idx<0) idx = -(idx+1);
			// LIS 배열을 업데이트
			// idx==lis.size()이면 새로운 요소가 추가되었음을 의미.
			if(idx==lis.size()) lis.add(num);
			else lis.set(idx,num);
		}
		// 전체 전깃줄 개수에서 LIS 길이를 빼면 최소로 제거해야 하는 전깃줄 개수
		System.out.println(N-lis.size());
	}

}
