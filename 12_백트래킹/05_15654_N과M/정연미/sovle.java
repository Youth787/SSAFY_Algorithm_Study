package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 허용안됨. 순열. nPr 문제
// 순열은 중복 허용되지 않을경우 불린 배열을 사용. 

public class n과m5 {
	static int N,M;
	static int[] nums, result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		result = new int[M];
		nums = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		nPr(0);
	}
	public static void nPr(int depth) {
		if(depth==M) {
			for(int a : result) System.out.print(a+" ");
			System.out.println();
			return;
		}// 기저 파트 
		
		for(int i=0; i<N;i++){
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = nums[i];
				nPr(depth+1);
				visited[i]= false;
			}
		}	
	}// method end 
}
