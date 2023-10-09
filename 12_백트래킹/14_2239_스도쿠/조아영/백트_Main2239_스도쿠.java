import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://sorjfkrh5078.tistory.com/22
public class 백트_Main2239_스도쿠 {
	
	static int n = 9;
	static int[][] sudoku = new int[n][n];
	static boolean end; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<n; i++) {
			String nums = br.readLine();
			for (int j=0; j<n; j++) {
				sudoku[i][j] = nums.charAt(j)-'0'; //입력 받아서 
			}
		}
		dfs(0); //탐색 돌립니다 
		
		for (int[] i:sudoku) {
			for (int j:i) {
				System.out.print(j); //출력
			}
			System.out.println();
		}
	}

	static void dfs(int cnt) {
		if (cnt==81) { //9*9=81 모든 칸 채웠으면 
			end = true; //끝냄 표시 하고 리턴 
			return;
		}
		
		int r = cnt/9; //현재 행
		int c = cnt%9; //현재 열
		
		if (sudoku[r][c]!=0) dfs(cnt+1); //이미 칸 채워져 있으면 다음 칸 ㄱㄱ  
		else { //칸 안 채워져 있으면 
			for (int i=1; i<=9; i++) { //거기에 1에서 9까지 넣어볼 건데 
				if (!isPossible(r,c,i)) continue; //쓸수없는숫자면 넘어가고 
				sudoku[r][c] = i; //쓸수있는거면 일단 해당숫자 넣어
				dfs(cnt+1); //그리고 다음 칸 ㄱㄱ 
				if (end) return; //만약 끝났으면 리턴
				sudoku[r][c] = 0; //여기로 왔다는건 아직 안끝났단 뜻임 칸에 숫자 썼던 거 지워! 다른 숫자 써봐야 하니까 
			}
			
		}
	}
	
	static boolean isPossible(int r, int c, int n) {
		
		for (int i=0; i<9; i++) {
			if (sudoku[r][i]==n || sudoku[i][c]==n) return false; //같은 행이나 열에 n 있으면 사용 불가 
		}
		int rs = r/3*3;
		int cs = c/3*3;
		for (int i=rs; i<rs+3; i++) {
			for (int j=cs; j<cs+3; j++) {
				if (sudoku[i][j]==n) return false; //3*3 안에 n 있으면 불가 
			}
		}
		return true; //여기까지 내려왔으면 숫자 n 사용가능 
	}
	
}
