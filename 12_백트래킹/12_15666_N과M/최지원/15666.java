package p15666_n과m12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;


//n개 자연수 중 (중복 선택 가능) m개 고른 수열 모두 출력...조합
//고른 수열은 비내림차순=길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
public class Main {

	static int n, m;
	static int [] nums, arr;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> str = new HashSet<>();//같은 순열을 뽑지 않기 위해
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//자연수  개수
		m = Integer.parseInt(st.nextToken());//몇개 뽑을지
		nums = new int [n];
		arr = new int [m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		//입력

		DFS(0, 0);
		
		System.out.println(sb);
		
	}//main
	
	public static void DFS(int idx, int depth) {
		if (depth == m) {
			StringBuilder tmp = new StringBuilder();//내부에서 이어붙일 때 사용하는 tmp
			for (int i = 0; i < m ; i++) tmp.append(arr[i]).append(' ');
			tmp.append('\n');//줄바꿈까지 한번에 저장해두고
			
			if(!str.contains(tmp.toString())) {
				//최종 정답 출력을 위해 sb에도 저장해주고
				sb.append(tmp);
				//같은 순열을 뽑지 않기 위해 str에도 저장해줘야 함
				str.add(tmp.toString()); 
			}

			return;
		}//기저		

    //i는 idx부터= 조합이라서. 재귀시 i를 넣음 = 중복해서 뽑을 수 있기 때문에
		for (int i = idx; i< n ; i++) { 
				arr[depth] = nums[i];
				DFS(i, depth+1); 
		}//재귀

	}//DFS

}//class
