package p15657_N과M_8;

import java.util.Arrays;
import java.util.Scanner;

//n개 자연수 중 (중복 선택 가능) m개 고른 수열 모두 출력
//고른 수열은 비내림차순=길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
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
		
		for (int i = idx; i< n ; i++) {
			arr[sIdx] = nums[i];
			DFS(i, sIdx+1); //앞 문제랑 달라진 부분. i+1이 아니라 i를 넣는 이유는 숫자를 중복으로 뽑을 수 있기 때문
		}
	}

}//class
