package p9663_N_Queen;

import java.util.Scanner;

public class Main {
	
	static int n, cnt;
	static int [] board;//안의 값에는 그 index 번째 세로줄에 몇번째 칸에 퀸이 있는지 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cnt = 0;
		board = new int [n];
		
		//퀸 n개를 서로 공격할 수 없게 만드는 방법
		DFS(0);
		
		System.out.println(cnt);
	}//main
	
	//어디까지 뽑았나 depth
	public static void DFS(int depth) {
		//기저
		if (depth == n) {// 0~n-1번 줄까지 (끝까지) 다 뽑았으면 depth가 n이 됨 
			cnt++; //방법 수 +1
			return; //리턴
		}

		//재귀
		for (int j = 0; j < n ; j++) { //j는 그 가로 줄의 어디에 퀸을 둘 것인지
			board[depth] = j;//depth번째 줄에서는 j번째 칸에 넣을 거야
			
			// 만약 지금까지 넣은 퀸들을 확인해보면서 그 자리가 공격받지 않는 자리라면 다음줄로 넘어가
			boolean tmp = true;
			out : for (int i = 0; i < depth; i++) {
				if (board[i] == board[depth]) {//같은 세로줄에 있다면 
					tmp = false;//안됨
					break out;//나가
				} else if (depth - i == Math.abs(board[depth] - board[i])) {//대각선 위치에 있다면
					//열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다 ( https://st-lab.tistory.com/118 )
					//depth - i = 지금 줄-0,1,2.. = depth 보다 1줄 위, 2 줄 위 : 음수 발생x
					//board[depth] - board[i] = 가로칸 값 들의 차이 : 이 경우에는 음수가 발생할 수 있으니까 Math.abs 써줘야 함
					tmp = false;//안됨
					break out;//나가
				}
				
				//break 없이 여기까지 왔다면 tmp 값은 계속 true겠지
			}// 가능한 위치인지 확인하는 for문
			
			if (tmp) DFS(depth+1);
		}
	}//DFS
}//class
