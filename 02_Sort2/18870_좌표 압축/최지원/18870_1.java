//풀다가 중복 제거 못해서 실패한 버전(!!!서로 다른!!! 좌표 Xj의 개수)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [문제] 수직선 위 N개의 좌표에 압축을 적용한 결과 출력. 압축 결과는 Xi > Xj를 만족하는 !!!서로 다른!!! 좌표 Xj의 개수와 같음
 * [입력] 첫 줄에 좌표 개수 N, 다음 줄에 공백으로 구분된 좌표들 (출력도 한 칸으로 구분)
 * [조건] 1<=N<=1000000. -10^9 <= 좌표 <= 10^9 
 * */

/* 압축 결과 = Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수 
 * [예제 입력] 2 4 -10 4 -9
 * [압축 결과] 2(2보다 작은 수 2개) 3(4보다 작은 수 3개) 0(-10보다 작은수 0개) ...
 * */

public class p18870 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 사용
		int N = Integer.parseInt(br.readLine()); //좌표 개수 N
		
		int [][] arr = new int[N][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < N ; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0 ; i < N ; i++) {
			int cnt = 0;
			for (int j = 0; j < N ; j++) {
				if (arr[i][0] > arr[j][0]) {
					cnt++;
				}
			}
			arr[i][1] = cnt;
		}
		
		for (int i = 0 ; i < N ; i++) {
			System.out.print(arr[i][1]+" ");
		}
		

	}

}
