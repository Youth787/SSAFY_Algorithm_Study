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


		//최빈값
		//배열된 상태에서 cnt, mode와 비교
		int cnt = 0;
		int mode = 0;

		//최빈값을 저장하는 ArrayList
		ArrayList<Integer> arrList = new ArrayList<Integer>(); 
		
		for (int i = 0; i < N-2; i++) {
			//뒤에 있는 값이랑 같다면 cnt+1
			if ( arr[i]==arr[i+1] )	{
				cnt++;
			} else	{
				//아니면 그 수는 여기까지다 =>현재 mode와 비교+ cnt 초기화
				if (mode <= cnt){
					if (mode == cnt) {
						arrList.add(arr[i]);
						cnt=0;
					} else {
						mode= arr[i]; //최빈값 
						arrList.clear();
						arrList.add(arr[i]);
					}
				}		
			}
			//출력을 어쩧ㄹ까핳
		}
		//범위 출력=최대값-최소값
		System.out.println(arr[N-1]-arr[0]);
	}
}
