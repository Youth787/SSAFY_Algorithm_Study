package p15656_N과M_7;

import java.util.Arrays;
import java.util.Scanner;

//n개 자연수 중 (중복 선택 가능) m개 고른 수열 모두 출력
public class Main {

	static int n, m;
	static int [] nums, arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();//자연수  개수
		m = sc.nextInt();//몇개 뽑을지
		nums = new int [n];
		arr = new int [m];
		for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		
		DFS(0,0);
		
		System.out.println(sb);
		
	}//main
	
	public static void DFS(int idx, int sIdx) {
		if (sIdx == m) {
			for (int i = 0; i < m ; i++) sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i< n ; i++) {
			arr[sIdx] = nums[i];
			DFS(i+1, sIdx+1);
		}
	}

}//class
