import java.util.Scanner;

public class bj2239 {

	static boolean flag;
	static int[][] sdoku;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sdoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = str.charAt(j) - '0';
			}
		}
		//입력 끝
		
		dfs(0);
		
		for (int[] a: sdoku) {
			for (int b: a) {
				sb.append(b);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int depth) { // 0부터 81까지 돌릴거임
		if (depth == 81) {
			flag = true;
			return;
		}
		
		int r = depth / 9; // 행
		int c = depth % 9; // 열
		
		if (sdoku[r][c] != 0) {
			dfs(depth + 1); // 0이아니면 숫자를 넣을 수 없으니 다음 자리로 넘어가자
		} else {
			for (int i = 1; i < 10; i++) {
				if (!isValid(r, c, i)) continue; // 숫자 넣을 수 있는지 확인했는데 만약 false면 넘어가기
				sdoku[r][c] = i; // 숫자넣을수 있으면 넣기
				dfs(depth + 1); // 넣어줬으니 다음으로 넘어가자
				
				//dfs끝나고 나왔을 때, 종료조건이 아니라면 더이상 선택할 수가 없다는 뜻 > 백트래킹!
				if (flag) return; 
				sdoku[r][c] = 0;
			}
		}
		

	}
	static boolean isValid(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (sdoku[i][c] == n || sdoku[r][i] == n) return false; // 가로 세로 확인!
		}
		// 9개의 자리 확인!
		int sr = r / 3 * 3; 
		int sc = c - c % 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc+ 3; j++) {
				if (sdoku[i][j] == n) return false; // 만약 숫자가 있다면 false반환.
			}
		}
		return true; // 다 아니라면 트루!
	}
}

//https://hailey-v.tistory.com/34

