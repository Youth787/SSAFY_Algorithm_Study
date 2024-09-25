package p11729_하노이탑이동순서;
/*
 * 3개 장대, n개의 원판. 최소 이동횟수 
 * stack 3개 만들고 이전 값이 
 * 3번째 장대의 stack size가 n이 되면 종료
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int count = hanoi(N, 1, 2, 3, 0, sb);
		
		bw.write(String.valueOf(count)+"\n");
		bw.write(sb.toString());	
	} //main
	
	public static int hanoi(int n, int start, int sub, int to, int count, StringBuilder sb) {
		
		count++;
		
		if(n == 1) {
			sb.append(start + " " + to + "\n");
			return count;
		}
		
		count = hanoi(n-1, start, to, sub, count, sb);
		sb.append(start + " " + to + "\n");
		count = hanoi(n-1, sub, start, to, count, sb);
		
		return count;
	}
}
