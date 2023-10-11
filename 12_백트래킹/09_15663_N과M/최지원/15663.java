package p15663_n과m9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Iterator;


//n개 자연수 중 (중복 선택 가능) m개 고른 수열 모두 출력
//고른 수열은 비내림차순=길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
public class Main {

	static int n, m;
	static int [] nums, arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
//	static List <String> str = new ArrayList<>(); 이거 쓰려고 했는데 시간초과
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

		DFS(0);
		
		// Iterator를 사용 HashSet 배열 출력 ( https://crazykim2.tistory.com/582 )
		Iterator<String> iter = str.iterator();
		while(iter.hasNext()) System.out.println(iter.next());
		
	}//main
	
	//nums을 계속 처음것부터 돌아야함. 뽑은 수는 제외해야 하고
	public static void DFS(int depth) {
		if (depth == m) {
			for (int i = 0; i < m ; i++) sb.append(arr[i]).append(' ');
//			if (!str.contains(sb.toString())) str.add(sb.toString()); 만약 ArrayList<>() 사용했다면 중복 제거를 위해 이렇게 하려고 했음
			str.add(sb.toString()); 
			sb = new StringBuilder();
			return;
		}//기저		
		
		//앞에 문제들처럼 visited 안쓰고 for문  i = idx시작 으로 처리하려고 했는데
		//그렇게 되면 nums[1] 뒤에 nums[0]이 오는 상황을 못만들어서 빠꾸할 수 있게 만들수밖에 없었음
		for (int i = 0; i< n ; i++) {
			//이미 사용한 수는 패쓰
			if (visited[i]) continue;
			//i를 뽑을 경우
			visited[i] = true;
			arr[depth] = nums[i];
			DFS(depth+1); 
			//i를 안 뽑을 경우
			visited[i] = false;		
		}//재귀

	}//DFS

}//class
