package p21943_연산최대로;
/*
 * 길이 n 수식을 왼쪽부터 순서대로 계싼. 0~9 정수와 우선순위 없는 연산자 + - x
 * 중첩된 괄호는 없다
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	static boolean[] check;
	static int plus; //연산자 개수
  static int mul;
  static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());//정수 개수
		int[] arr = new int[n]; //정수 저장 배열
		check = new boolean[n]; //연산자 구분 배열 ( true = + , false = * )
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken()); //더하기 연산자 수
		mul = Integer.parseInt(st.nextToken()); //곱하기 연산자 수
		max = Integer.MIN_VALUE;
		
		
		boolean[] oper = new boolean[n-1]; //+ 사용했으면 true , * 사용했으면 false. 연산자 개수는 숫자보다 1 적음
		StringBuilder sb = new StringBuilder();
		back(0, arr, oper, sb); //백트래킹
		System.out.println(max);
	} //main

  //수의 조합을 만드는 백트래킹
	public static void back(int depth, int[] arr, boolean[] oper, StringBuilder sb) {
		if(depth == arr.length) {
			int[] nums = new int[arr.length];
			for(int i=0; i<sb.length(); i++) 
				nums[i] = sb.charAt(i)-'0';
			
			back2(0, 0, nums, oper);// 수의 조합 만들었으면 다음으로는 연산자 조합 만들기
		}
		
		for(int i=0; i<check.length; i++) {
			if(check[i]) continue;
			check[i]=true;
			sb.append(arr[i]);
			back(depth+1, arr, oper, sb);
			check[i]=false;
			sb.delete(sb.length()-1, sb.length());
		}
	} //back1

  //연산자 조합 만드는 백트래킹
  // a:이전에 +했던 자리는 건너뛰기 / depth: +개수 / nums:조합된수들 / oper: 연산자 표현 
	public static void back2(int a, int depth, int[] nums, boolean[] oper) {
		//true를 + 개수만큼 해줬을때 종료.
		if(depth == plus) {
			int[] sum = new int[mul+1];// +한 값을 넣어 주기위한 공간 
			int idx = 0;
			for(int i =0; i<oper.length; i++) {
				//첫번째 연산자가 +일때는 sum에 더한값 넣어줌
				if(i==0 && oper[i]) {
					sum[idx] += nums[i]+nums[i+1];
				}
				//현재 +일때 이전에도 +라면 이전까지 더한 sum값에 현재 더할 nums를 더해줌.
				else if(oper[i] && oper[i-1]) {
					sum[idx] += nums[i+1];
				}
				//현재 *일때는 이전값에서 더하는게 아님.
				//새로운 sum을 만들어줌.
				else if(!oper[i]) {
					idx++;
					sum[idx] += nums[i+1];
				}
				//현재 +인데 이전에 *였을때도 sum에 현재 더할 nums를 더해줌. 
				else if(oper[i] && !oper[i-1]) {
					sum[idx] += nums[i+1];
				}
			}
			//첫번째값이 *였다면 sum[0]에 nums[0] 넣어주기
			if(!oper[0]) sum[0] = nums[0];
			int res = 1;
			for(int s:sum) res *= s;//곱하기
			max = Math.max(res, max);
		}
		
		//+ 개수만큼 표시해주기
		for(int i=a; i<oper.length; i++) {
			if(oper[i]) continue;
			oper[i]=true;
			back2(i,depth+1, nums, oper);
			oper[i]=false;
		}
	} //back2
} //class
