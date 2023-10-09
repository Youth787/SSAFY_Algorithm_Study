import java.util.Scanner;

public class 백트_Main9663_NQueen {
	
	static int n,ans;
	static boolean[][] visited;
	static int[] dr = {-1,-1,-1}; //좌상,상,우상
	static int[] dc = {-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //퀸 개수 
		visited = new boolean[n][n]; //방문체크할 체스판 배열 
		ans = 0; //정답 개수 
		dfs(0); //완탐 돌립니다 
		System.out.println(ans); //답 출력 
	}
	
	static void dfs(int cnt) { //cnt는 행 번호이면서 퀸 몇개 뽑았는지에 대한 정보임 (nqueen 정답은 1행 1퀸 나와야 함)  
		if (cnt==n) { //n개 다 뽑았으면 정답 +1하고 리턴 
			ans++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			boolean possible = true; //queen을 놓을 수 있는 칸인지 판별 
			
			outer : for (int j=0; j<dr.length; j++) { //dr,dc 돌려야 함 
				for (int k=0; k<n; k++) { //n*n 배열이므로  
					int x = cnt+dr[j]*k; 
					int y = i+dc[j]*k;
					if (x>=0 && x<n && y>=0 && y<n && visited[x][y]) { //내 현재위치(cnt,i)의 좌상, 상, 우상 방향에 퀸 있으면 
						possible = false; //현재위치(cnt,i에 퀸 못 놓으므로) boolean false로 바꿔주고 
						break outer; //false가 나왔으니 더 판별 의미없어 반복문 깨 
					}
				}
			}
			
			if (possible) { //현재위치(cnt,i)에 queen 놓을 수 있으면 
				visited[cnt][i] = true; //놨다고 체크하고 
				dfs(cnt+1); //다음 행(=다음 퀸) 재귀호출 
				visited[cnt][i] = false; //다녀왔으면 방문쳌 해제 		
			}
		}
	}

}
