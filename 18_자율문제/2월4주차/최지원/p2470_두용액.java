import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //배열 크기 n
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[2]; // 결과 저장(선택된 두 원소)
		int s = 0; // 투 포인터 - 시작점
		int e = n-1; // 투 포인터 - 끝점
		int min = Integer.MAX_VALUE; // 두 원소 합 중 0에 가장 가까운 값을 저장하는 변수
		Arrays.sort(arr); // 오름차순 정렬

		// 투 포인터 사용하여 두 원소의 합이 0에 가장 가까운 쌍 찾는 반복문
		while(s < e) { 
			int sum = arr[s] + arr[e]; // 현재 포인터가 가리키는 두 원소 합 계산
			// 절대값 처리
			if (min > Math.abs(sum)) { // 새로운 최소값이 발견되면 res 갱신
				min = Math.abs(sum);
				res[0] = arr[s];
				res[1] = arr[e];		
				if (sum == 0) {
					break;
				} // 합이 0이면 이제 더이상 볼 필요 없으니까 반복문 종료
			} 

			// 이제 포인터 이동
			if(sum < 0) {
				s++; // 합이 0보다 작았으면 시작점을 오른쪽으로 이동
			} else {
				e--; // 0보다 크면 끝점을 왼쪽으로 이동
			} //
			
		} // 투 포인터 반복문		
		System.out.println(res[0]+" "+res[1]);
	} //main
} //Class
