import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
	
	static int n; // w:흰종이, b: 블루종이
	static int w = 0;
	static int b = 0;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
		st = new StringTokenizer(br.readLine(), " "); // 이거넘신기하다 첨봤어
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		partition(0, 0, n);
		System.out.println(w);
		System.out.println(b);
		
	}
	static void partition(int r, int c, int size) {
		if (colorCheck(r, c, size)) { // 만약 true라면 종이 끝난거니까 
			if (paper[r][c] == 0) // 0이면 흰색 추가
				w++;
			else 
				b++; // 1이면 블루 추가
			
			return; // 더이상 자르지말고 돌려보내라.
		}
		
		int newSize = size / 2;
		partition(r, c, newSize);					            //2사분면
		partition(r, c + newSize, newSize);		       	//1사분면
		partition(r + newSize, c, newSize); 		      //3사분면
		partition(r + newSize, c + newSize, newSize); //4사분면
	}
	static boolean colorCheck(int row, int col, int size) { // 전부 흰색인지 블루인지 체크체크
		int color = paper[row][col]; // 컬러를 숫자형으로 받아서 지정해두고
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (paper[i][j] != color) // 다른게있따고?! 그럼 false!!
					return false;
			}
		}
		return true; // 다른게 없다면 true반환!
	}
}

//https://st-lab.tistory.com/227
