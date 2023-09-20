
//[문제] n명이 1명 이상의 두 팀으로 나눌 때 두 팀 시너지 차이가 최소가 될 때의 그 최소값 출력
//[입력] n / 시너지들이 n개씩 n줄. 본인은 0으로 입력됨
import java.util.Scanner;

public class Main {
	
	static int min, ans, n;
	static int [][] sng;
	static boolean [] visited; //스타트팀에 들어갔나 아닌가 확인
	
	//p1는 전체 n명 중 몇 번째 사람? p2는 스타트 팀에 몇 명이 들어있는지
	static void DFS(int p1, int p2) {
		//기저
		if (p1 == n) {
			if ( p2 == n-1 || p2 == 0 ) return; //한 팀에 1명 이상이 아닌 경우니까
			//위에 조건에 안걸리고 내려왔다면 이제 시너지 합 최소가 맞는지 확인
			int s1 = 0;//스타트팀 시너지 합
			int s2 = 0;//링크팀 시너지 합
			for (int i = 0; i < n; i++) {
				if (visited[i]) { //i가 스타트팀이면
					for (int j = 0; j < n; j++) {
						if (visited[j]) { //j가 스타트팀이면
							s1 += sng[i][j];
						}
					}
				} else { //i가 링크팀이면
					for (int j = 0; j < n; j++) {
						if (!visited[j]) { //j가 링크팀이면
							s2 += sng[i][j];
						}
					}
				}
			}
			ans = Math.min(ans, Math.abs(s1-s2)); //시너지 차의 절대값과 지금 최소값의 비교
			return;
		}//기저
		
		//재귀
		//[1] p1을 스타트팀에 넣는다
		visited[p1] = true;
		DFS(p1+1,p2+1);//다음 재귀
		//[2] p1을 스타트팀에 안 넣는다
		visited[p1] = false;
		DFS(p1+1,p2);//다음 재귀		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력값 저장
		n = sc.nextInt(); //사람 수
		sng = new int [n][n];
		visited = new boolean [n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sng[i][j] = sc.nextInt();
			}
		}//입력값 저장 끝
		
		ans = Integer.MAX_VALUE;
		
		DFS(0,0);
		
		System.out.println(ans);

	}//main
}//class
