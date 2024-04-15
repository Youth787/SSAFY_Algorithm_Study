package p1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 길이가 다른 k개의 랜선을 (정수)cm 만큼 잘라서 같은 길이의 n개 이상의 랜선을 만듬
 * 만들 수 있는 최대 랜선의 길이
 * 
 * k n / 각 랜선 길이
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		
		//이분탐색을 위한 max, min, mid
		long max = 0; //랜선의 길이는 2의31승-1보다 작거나 같은 자연수
		long min = 0;
		long mid = 0;
		
		/* 구해야 하는 값은 랜선 길이이므로, 이분탐색할때 랜선 길이 기준으로 범위 설정
		 * 특정 개수에 대한 특정 (최대) 길이 찾기 <Upper Bound 방식>
		 * mid로 자를 때 개수가 작으면 최대길이를 줄인다 vs. 최소 길이를 늘린다*/
		
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i]; //입력하면서 최대값 미리 찾기
			}
		}
		
		max++;//max +1에서 시작
		
		while (min < max) {
			mid = (max + min) / 2; //새로운 범위에서의 mid를 찾고
			long cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += (arr[i] / mid); //몫으로 막대기 몇개 만들어지는지 cnt
			}
			
			if (cnt < n) {
				max = mid; //목표 개수 n개 이상을 만들어야 하니까, "최대" 랜선 길이를 mid 위치로
			} else {
				min = mid + 1; //최대 길이 구해보기 위해, "최소" 랜선 길이를 mid + 1 위치로
			}
		} //이분탐색
		
		System.out.println(min - 1);
		
	} //main

} //class
