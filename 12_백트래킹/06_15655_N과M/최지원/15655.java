import java.util.Arrays;
import java.util.Scanner;

/*[문제] N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. 
N개의 자연수는 모두 다른 수이다.N개의 자연수 중에서 M개를 고른 수열. 고른 수열은 오름차순이어야 한다.
중복되는 수열을 여러 번 출력하면 안되며 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
조합?이라고 생각함 ( 1 7, 7 1 이 나올 수 없으니까)
*/

/*
테케
4 2
9 8 7 1

1 7,1 8,1 9,7 8,7 9,8 9
*/

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
		
		Arrays.sort(nums); //수열을 오름차순으로 만들기 위해

		DFS(0,0);
		
		System.out.println(sb);
		
	}

	//DFS. 인자로 n개의 자연수 중 몇 번째를 돌고 있는지(idx)와, m개 중 몇 개를 골랐는지(sIdx) 받음
	public static void DFS(int idx, int sIdx) {
		if (sIdx == m) { //sIdx == m일때 m개 다 뽑았다
			for (int i = 0; i < m ; i++) sb.append(arr[i]).append(' '); 
			sb.append('\n'); //sb에 넣는 중
			return; //리턴
		}//기저
		
		for(int i = idx; i < n; i++) { //for문을 도는 시작점은 i = idx부터. i < n
			arr[sIdx] = nums[i];
			DFS(i+1, sIdx+1); //다음 수
		}//재귀
		
	}//DFS

}//class
