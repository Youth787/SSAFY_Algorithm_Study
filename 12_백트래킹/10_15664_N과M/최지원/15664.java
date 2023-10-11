package p15663_n과m9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Iterator;


//n개 자연수 중 m개 고른 수열 모두 출력
//고른 수열은 비내림차순=길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
public class Main {

	static int n, m;
	static int [] nums, arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<String> str = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//자연수  개수
		m = Integer.parseInt(st.nextToken());//몇개 뽑을지
		nums = new int [n];
		arr = new int [m];
		visited = new boolean [n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);

		DFS(0, 0);
		
		// Iterator를 사용 HashSet 배열 출력 ( https://crazykim2.tistory.com/582 )
		Iterator<String> iter = str.iterator();
		while(iter.hasNext()) System.out.println(iter.next());
		
	}//main
	
	public static void DFS(int idx, int depth) {
		if (depth == m) {
			for (int i = 0; i < m ; i++) sb.append(arr[i]).append(' ');
//			if (!str.contains(sb.toString())) str.add(sb.toString()); 만약 ArrayList<>() 사용했다면 중복 제거를 위해 이렇게 하려고 했음
			str.add(sb.toString()); 
			sb = new StringBuilder();
			return;
		}//기저		
		
		for (int i = idx; i< n ; i++) {
			arr[depth] = nums[i];
			DFS(i+1, depth+1); 	
		}//재귀

	}//DFS

}//class
