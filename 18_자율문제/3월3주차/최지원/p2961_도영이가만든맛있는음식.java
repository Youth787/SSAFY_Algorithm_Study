package p2961_도영이가만든맛있는음식;

import java.util.Scanner;

/*
 * n개 재료에 각각 신맛s, 쓴맛b가 있음
 * 신맛 = 곱, 쓴 맛 = 합
 * 재료를 하나 이상 사용 & 신 맛과 쓴 맛의 차이 최소로
 * 
 * 입력 n / (n개) 신맛 쓴맛
 * */
public class Main {
	static int n; //재료 개수
	static int ans; //정답
	static int[][] info; //재료 정보
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		info = new int[n][2];
		for (int i = 0; i < n; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0, 1, 0);
		//dfs 시작값=> 재료idx값 = 0번부터 , 신 맛 곱 초기값 = 1 , 쓴 맛 합 초기값 = 0
		
		System.out.println(ans);
	} //main
	
	static void dfs (int idx, int sumS, int sumB) {
		//sumS = 음식 신 맛(값의 곱)
		//sumB = 음식 쓴 맛(값의 합)
		if ( idx == n ) {
			//기저: 재료 끝까지 다 돈 상황
			if (sumS == 1 && sumB == 0) {
				return;
				//음식의 신맛, 쓴맛 계산 시 합의 초기값이 sumS는 1(곱이니까), sumB는 0임(합이니까)
				//sumS == 1 && sumB == 0 라면 재료를 아무것도 사용하지 않은 경우임
			}
			ans = Math.min(ans, Math.abs(sumS - sumB)); //신맛 쓴맛 차이(절대값)과 현재까지 구한 최소값을 비교해서 값 갱신
			return;
		}
		
		//재귀
		dfs(idx+1, sumS*info[idx][0], sumB+info[idx][1]); //idx 재료 넣었다
		dfs(idx+1, sumS, sumB); //idx 재료 안 넣는다
	} //dfs
	
} //class
