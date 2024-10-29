package _20241025;

import java.util.*;
import java.io.*;

public class _17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] NGE = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> num = new Stack<>();
		
		for(int i=N-1;i>=0;i--) {
			// 뒤에서부터 오큰수를 구하기 시작
			// num이 비어있지 않으면 맨 위에(최근수)와 비교해서 현재 수보다 작으면 빼준다
			// 어차피 현재 수가 들어가면 작은수는 필요없어지기 때문
			while(!num.isEmpty() && num.peek()<=A[i]) {
				num.pop();
			}
			// num이 비어있다면 비교 대상인 수가 아직 없단 뜻이므로 -1이 오큰수이다
			// 그렇지 않다면 num 맨 위에 수가 오큰수이다. 이미 작은 애들은 위에서 빼버렸기 때문
			NGE[i] = num.isEmpty() ? -1 : num.peek();

			// 현재 수를 num에 추가해준다
			num.add(A[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(NGE[i]).append(" ");
		}
		System.out.print(sb.toString().trim());
		
	}

}
