/*
  문제 : n개의 양의 정수 x들과 (n-1)개의 곱하기 연산자 or 더하기 연산자를 사용하여 (괄호는 사용 제한 없음) 최대값을 만드는 문제. 
  - 정수의 순서 바꿔도 상관 없고, 정수 연산자 번갈아가며 배치해야 함. 
  - 괄호 외에 연산자 우선순위 없음.

  입력 : 첫째 줄 n/ 다음 줄 n개의 양의 정수(공백 구분) / 마지막 줄 더하기 연산자 개수 p, 곱하기 연산자 q(공백 구분)
  
*/

/*
  풀이 1 : 백트래킹 2번 사용 (모든 수의 조합, 모든 연산자의 조합 구하는 데 이용)
  조합된 것들을 이용하여 값을 계산
  연산자 2가지이기 때문에 boolean 배열로 true = + , false = * 로 표현
  더하기 먼저 계산 후, 나중에 곱셈 계산
  https://record-developer.tistory.com/164
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	static boolean[] check;
	static int plus, mul, max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());//정수 개수
		int[] arr = new int[n]; //정수 저장 배열
		check = new boolean[n]; //연산자 구분 배열 ( true = + , false = * )
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken()); //더하기 연산자 수
		mul = Integer.parseInt(st.nextToken()); //곱하기 연산자 수
		max = Integer.MIN_VALUE; //최대값 구해야 하니까 최소값으로 초기화
		
		
		boolean[] oper = new boolean[n-1];//어떤 연산자 사용했는지 표현, true==+ , false==*
		StringBuilder sb = new StringBuilder();//조합된 수 표현
		back(0,arr,oper,sb);//백트래킹
		System.out.println(max);
	}

  //백트래킹 1번째 : 수의 조합 만들기
	public static void back(int depth, int[] arr, boolean[] oper, StringBuilder sb) {
		if(depth==arr.length) {
			int[] nums = new int[arr.length];
			for(int i=0; i<sb.length(); i++) 
				nums[i] = sb.charAt(i)-'0';
			
			back2(0,0,nums,oper);// 수의 조합 만들었으면 다음으로는 연산자 조합 만들기
		}
		
		for(int i=0; i<check.length; i++) {
			if(check[i]) continue;
			check[i]=true;
			sb.append(arr[i]);
			back(depth+1, arr, oper, sb);
			check[i]=false;
			sb.delete(sb.length()-1, sb.length());
		}
	}

  //백트래킹 2번째 : 연산자 조합 
  // a:이전에 +했던 자리는 건너뛰기 / depth: +개수 / nums:조합된수들 / oper: 연산자 표현 
	public static void back2(int a, int depth, int[] nums, boolean[] oper) {
		//true를 + 개수만큼 해줬을때 종료.
		if(depth==plus) {
			int[] sum = new int[mul+1];// +한 값을 넣어 주기위한 공간 
			int idx=0;
			for(int i=0; i<oper.length; i++) {
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
	}
}

