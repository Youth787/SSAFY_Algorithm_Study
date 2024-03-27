package p11659_구간합구하기4; //시간 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수 n개가 주어지면 i번째 수부터 j번째 수까지의 합을 구하는 프로그램 작성
 * (입력) 수의 개수 n, 합을 구해야 하는 횟수 m / n개의 수 / (m개 줄) 합을 구해야 하는 구간 i와 j
 * */
public class Main {
	static int n; //몇 개의 수가 주어질지
	static int m; //몇 번의 구간을 줄건지
	static int[] number; //n개의 수 저장
	static StringBuilder sb; //각 경우의 구간합을 저장해서 한번에 출력할 거임
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}//1번째부터 시작하도록 n+1로 index 설정
		sb = new StringBuilder();
		for (int tc = 1; tc <= m; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int ii = i; ii <= j; ii++) {
				sum += number[ii];
			}
			sb.append(sum).append('\n');
		} //tc
		
		System.out.println(sb);

	} //main
} //class
