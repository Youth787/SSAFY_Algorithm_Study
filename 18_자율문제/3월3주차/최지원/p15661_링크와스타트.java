package p15661_링크와스타트;

import java.util.Scanner;

/*
 * n명이서 축구(1번~n번 사람)하려고 팀 쪼개고 능력치 계산
 * 팀 능력치는 팀에 속한 모든 쌍의 능력치 합 i-j 와 j - i값이 모두 다름
 * */
public class Main {
	static int min; //최소값
	static int ans; //답
	static int n; //사람 수
	static int[][] power; //능력치 합
	static boolean[] visited; //스타트팀 방문처리 배열 (링크팀

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		power = new int[n][n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				power[i][j] = sc.nextInt();
			}
		}
		
		ans = Integer.MAX_VALUE;
		dfs(0,0); //n명 중 몇 번째 사람? = 0, 스타트팀에 몇명? = 0
		System.out.println(ans);
	} //main
	
	static void dfs (int idx, int sIdx) {
		if (idx == n) {
			//기저
			if (sIdx == n-1 || sIdx == 0) {
				//한 팀에 1명 이상 있어야 함
				return;
			}
			int sumS = 0; //스타트팀 시너지 합
			int sumL = 0; //링크팀 시너지 합
			//for문 2개 돌면서, 같은 팀인 경우를 찾아 시너지 계산하는 과정			
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					for (int j = 0; j < n; j++) {
						if (visited[j]) { //이 조건까지 참이라면 i와 j가 둘 다 스타트팀이다
							sumS += power[i][j];
						}
					}
				} else {
					for (int j = 0; j < n; j++) {
						if (!visited[j]) { //i와 j가 둘 다 링크팀이다
							sumL += power[i][j];
						}
					}
				}
			}
			ans = Math.min(ans, Math.abs(sumS - sumL)); //시너지 차이 가장 적은 팀을 만들어 ans에 차이 저장
			return;
			
		}
		
		//재귀 : idx 선수를 스타트에, 또는 링크에
		visited[idx] = true; //스타트에
		dfs(idx+1, sIdx+1);
		visited[idx] = false; //링크에
		dfs(idx+1, sIdx);
	} //dfs
} //class
