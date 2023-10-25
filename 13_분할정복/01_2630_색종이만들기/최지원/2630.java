import java.util.Scanner;
 
public class Main {
	static int white = 0;
	static int blue = 0;
	static int [][] board;
 
	public static void main(String [] args) {		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		partition(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void partition(int r, int c, int size) {
    if(chk(r, c, size)) {
			if(board[r][c] == 0) white++;
			else blue++;
			return;
		}//기저 부분
		
		int mid = size/2;	//절반
    
		// 재귀 부분
		partition(r, c, mid);// 2
		partition(r, c + mid, mid);// 1
		partition(r + mid, c, mid);// 3
		partition(r + mid, c + mid, mid);	// 4
	}//partition
	
	public static boolean chk(int r, int c, int size) { //색 확인
		int color = board[r][c];
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(board[i][j] != color) return false;
			}//c
		}//r
		return true;//여기까지 나왔으면 true
	}//chk
}//class
