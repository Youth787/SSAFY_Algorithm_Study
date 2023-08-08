//제대로 못 푼 문제 - 최빈값이 이상해요ㅠ

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) throws IOException{
		//N(홀수) 와 N개의 줄에 정수들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//산술평균(소수점 이하 첫째 자리에서 반올림한 값 출력)
		int avg = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		avg = (int)sum/N;
		System.out.println(avg);
		
		//중앙값 출력 = N+1/2번째 = 인덱스는 -1
		//버블 정렬
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j <N-1; j++) {
				if ( arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(arr[(N+1)/2-1]);		
		
		
//		//최빈값 출력(최빈값 중 두번째로 작은 값)
//		//최소 -4000 부터 4000까지 = 8001개
//		//인덱스 0부터 값 입력. 인덱스마다 +4000
//		int [] nums = new int[8002];
//		for (int i= 0; i<N; i++) {
//			nums[arr[i]+4000]++;
//		}
//		int maxIdx = 0;		
//		for (int i= 0; i<8002; i++) {
//			if(nums[i]>maxIdx) {
//				maxIdx = nums[i];
//			}
//		} 
    
//		List<Integer> m = new ArrayList<>();
//		for (int i= 0; i<N; i++) {
//			m.add(arr[i]);
//		}
//		
//		int maxIdx = 0;		
//		for (int i= 0; i<8002; i++) {
//			if(nums[i]>maxIdx) {
//				maxIdx = nums[i];
//			}
//		}
//
//		List<Integer> m = new ArrayList<>();
//		for (int i= 0; i<8002; i++) {
//			if(nums[i]==maxIdx) {
//				m.add(i);
//				if (m.size()==2) {
//					System.out.println(maxIdx-4000);
//					break;
//				}
//			
//			} else if(nums[i]<maxIdx) {
//				System.out.println(maxIdx-4000);
//			}
//			
//		}
		
		//범위 출력=최대값-최소값
		System.out.println(arr[N-1]-arr[0]);

	}

}
