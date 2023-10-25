package p11663_선분위의점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//문제 : 일차원 좌표에 점 N개와 선분 M개가 있으면 각 선분 위에 입력으로 주어진 점이 몇 개 있는지
//입력: 첫줄에 n, m (1 ≤ N, M ≤ 100,000) / 둘째 줄에는 점의 좌표 / 이후부터는 선분의 시작점과 끝점
//모든 좌표는 1,000,000,000보다 작거나 같은 자연수니까 long하자
public class Main {
	
	static long [] point;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//점
		int m = Integer.parseInt(st.nextToken());//선분
		
		point = new long [n]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			point[i] = Long.parseLong(st.nextToken());
		}//점

		Arrays.sort(point);
		
		int [][] line = new int [m][2]; 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}//선분		

		//각 선분마다 체크하고 점 올라갈 수 있는지 찍어야함
		for (int i = 0; i < m; i++) {
            		int ans = chk(line[i][0] , line[i][1]);
            		sb.append(ans).append('\n');
        	}

		System.out.println(sb);
	}//main

	public static int chk(int x, int y){
		int low = 0;
		int high = point.length - 1;

		while (low <= high){
			int mid = (low + high)/2;

			if (point[mid] > y) high = mid-1;
			else low = mid +1;
		}
		int idx1 = high +1;

		//다시
		low = 0;
		high = point.length - 1;
		while (low <= high){
			int mid = (low + high)/2;

			if (point[mid] < x) low = mid +1;
			else high = mid-1;
		}
		int idx2 = low;

		return idx1 - idx2;
	}//chk
}//class
