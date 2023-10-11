import java.util.Arrays;
import java.util.Scanner;

//[문제] n개의 자연수와 자연수 m개가 주어졌을 때 오름차순으로 n개의 자연수 중 m개를 고른, 길이가 m인 수열을 모두 구하는 프로그램
public class Main {

	static int[] arr, nums;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		n = sc.nextInt();//자연수  개수
		m = sc.nextInt();//몇개 뽑을지
		nums = new int [n];
		arr = new int [m];
		for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
		
		Arrays.sort(nums);

		//조합 
		DFS(0,0);
		
		System.out.println(sb);
		
	}
	
	public static void DFS(int idx, int sIdx) {
		if (sIdx == m) {
			for (int i = 0; i < m ; i++) sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i = idx; i < n; i++) {
			arr[sIdx] = nums[i];
			DFS(i+1, sIdx+1);
		}
		
	}

}
