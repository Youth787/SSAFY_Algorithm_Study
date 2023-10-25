import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1992 {
	
	static int n;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		} // 입력 끝!
		partition(0, 0, n);
		System.out.println(sb);
		
	}
	static void partition(int r, int c, int size) {
		if (colorCheck(r, c, size)) { // 네모가 컬러가 일치한다면
			sb.append(map[r][c]); // 최종 답에 0이나 1 추가해주고
			return; // 돌아가!
		} else { // 네모가 컬러가 아니라면 괄호 열어줘야함!!!
			sb.append("(");
		}
		
		int newSize = size/2; // 1, 2, 3, 4분면 돌아돌아
		partition(r, c, newSize);
		partition(r, c + newSize, newSize);
		partition(r + newSize, c, newSize);
		partition(r + newSize, c + newSize, newSize);
		sb.append(")"); // 4분면까지 마쳤어? 어 괄호 닫아~
	}
	static boolean colorCheck(int r, int c, int size) { // 컬러가 전부 일치하나용 ?
		int color = map[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != color)
					return false; // 하나라도 아니라면 false
			}
		}
		return true;
	}
}

